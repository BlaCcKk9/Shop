package com.example.shop.network.error_handling

import android.content.Context
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.HttpException
import java.net.UnknownHostException

fun handleNetworkError(context: Context, t: Throwable?, apiErrorListener: ApiErrorListener?) {
    when (t) {
        is HttpException -> try {
            handleHttpException(context, t, apiErrorListener)
        } catch (e: Exception) {
        }
        is UnknownHostException -> handleNoInternetConnection(t, apiErrorListener)
        else -> handleGenericError(t, apiErrorListener)
    }
}

fun handleHttpException(context: Context, e: HttpException?, apiErrorListener: ApiErrorListener?) {
    if (e == null)
        return

    val errorJson = e.response()!!.errorBody()?.string()
    val jsonObj = JSONObject(errorJson.orEmpty())

    if (jsonObj.has("errors")) {
        val httpErrors = ArrayList<HttpError>()
        val errors = jsonObj.getJSONObject("errors")
        errors.keys().forEach {
            parseFieldErrors(errors.getJSONArray(it.toString())).forEach { error ->
                httpErrors.add(error)
            }
        }
        apiErrorListener?.onHttpErrors(httpErrors)
    } else if (jsonObj.has("error")) {
        val data = if (jsonObj.has("data")) Gson().fromJson<HttpError.Data>(
            jsonObj.getString("data"),
            HttpError.Data::class.java
        ) else null
        val httpError =
            HttpError(e.response()!!.code().toString(), jsonObj.getString("error"), data)
        apiErrorListener?.onHttpError(httpError)
    }
}

fun parseFieldErrors(errors: JSONArray): Collection<HttpError> {
    val list = ArrayList<HttpError>()
    (0 until errors.length())
        .map { errors.getJSONObject(it) }
        .mapTo(list) { HttpError(it.getString("code"), it.getString("message")) }
    return list
}

fun handleNoInternetConnection(e: UnknownHostException, apiErrorListener: ApiErrorListener?) {
    apiErrorListener?.onNoInternetConnection()
}

fun handleGenericError(t: Throwable?, apiErrorListener: ApiErrorListener?) {
    apiErrorListener?.onGenericError(t)
}

