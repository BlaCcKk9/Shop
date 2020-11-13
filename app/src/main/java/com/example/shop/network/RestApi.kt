package com.example.shop.network

import android.content.Context
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RestApi @Inject constructor(context: Context) {

    companion object{
        const val HEADER_AUTHORIZATION = "Authorization"
        const val ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkZmVlF4dkZYcHpJMV9CX09rZjNuMFEiLCJ0eXAiOiJKV1QifQ.eyJuYmYiOjE2MDUyNjQ4MzQsImV4cCI6MTkyMDYyNDgzNCwiaXNzIjoiaHR0cHM6Ly9tb2l0YW5lLWFwaS5sZW1vbi5kby8iLCJhdWQiOlsiaHR0cHM6Ly9tb2l0YW5lLWFwaS5sZW1vbi5kby9yZXNvdXJjZXMiLCJBcGkiXSwiY2xpZW50X2lkIjoiTW9pdGFuZSIsInNjb3BlIjpbIk1vaXRhbmVBcGkiXX0.diyROFEYR9UqUqMBOFHHOLeZRzJXMADoieBmipHI59hbCTtmUSObWNHIQ8FKVLdQ79DbENkj1f4cnxi_M2Wu_xfqZo2Fx-iKsHMWZuFQ-NtbKRtQ2Dn9AQKCffTJCsuA3uYjE1QN4zf1kbuKAdDMyP9oHFBTCu-Bd52XmSKn2rp3gzqKoWqPEeBso65TeOxAJ_8s1K4P77EPTofoqocsLeda-DWtcpVrhwOWsBSsBMqXf46638Bty6oKfNvuVK-zNfQM_gqAtJi02XV-rmSrT_2bAbEsV5J8GE0vsOOvdEHOZ6cfwbn8yumPkcQCe-fJTPpNtZZjTm9zfvhhyNpgEg"
        const val BASE_URL = "https://moitane-api.lemon.do/"
    }

    private lateinit var retrofit: Retrofit


    init {
        invalidate()
    }

    private fun invalidate() {
        initRetrofit()
        initServices()
    }

    private fun initRetrofit(){
        val client = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(RequestInterceptor())
            .build()

        retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private fun initServices(){

    }

    inner class RequestInterceptor : okhttp3.Interceptor {
        override fun intercept(chain: okhttp3.Interceptor.Chain): Response =
            chain!!.proceed(chain.request().newBuilder().apply {
                header(HEADER_AUTHORIZATION, "Bearer $ACCESS_TOKEN")
            }.build())
    }
}