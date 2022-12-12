package com.example.marvel_app_android.api


import okhttp3.Interceptor
import okhttp3.Response

internal class MarvelApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newHttpUrl = request.url.newBuilder()
            .addQueryParameter("ts", "1")
            .addQueryParameter("apikey", "e2d713ef3c683e06df7d7ea148aef15c")
            .addQueryParameter("hash", "f64bede11641777950a218667d1692ad")
            .build()
        val newRequest = request.newBuilder()
            .url(newHttpUrl)
            .build()
        return chain.proceed(newRequest)
    }
}
