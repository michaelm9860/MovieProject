package com.example.finalproject.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor(
    private val queryParam: String = "api_key",
    private val queryValue: String = "d116662fe59cb493ef02d8915360e9d9"
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val original: Request = chain.request()

        val url =
            original
                .url.newBuilder()
                .addQueryParameter(queryParam, queryValue)
                .build()

        //modify the request url:
        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}