package com.example.shop.network.error_handling

interface ApiErrorListener {
    fun onHttpErrors(errors: Collection<HttpError>)

    fun onHttpError(error: HttpError)

    fun onNoInternetConnection()

    fun onGenericError(t: Throwable?)

}