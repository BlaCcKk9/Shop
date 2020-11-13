package com.example.shop.network.error_handling

class HttpError(private val code: String? = "", val message: String? = "", val data: Data? = null) {

    companion object {
        const val UNAUTHORIZED = "401"
        const val FORBIDDEN = "403"
        const val NOT_FOUND = "404"
        const val SERVER_ERROR = "500"
    }

    fun isUnauthorized(): Boolean =
        code == UNAUTHORIZED

    fun isServerError(): Boolean =
        code == SERVER_ERROR


    data class Data(val reason: String? = "")
}