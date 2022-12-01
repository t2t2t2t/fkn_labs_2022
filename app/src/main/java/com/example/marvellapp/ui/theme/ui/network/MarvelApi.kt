package com.example.marvel_app.ui.theme.ui.network


import com.example.marvel_app.ui.theme.ui.model.Request
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelApi {

    @GET("characters?limit=10&apikey=e2d713ef3c683e06df7d7ea148aef15c&ts=1&hash=f64bede11641777950a218667d1692ad")
    fun getCharacters(): Call<Request>

    @GET("characters/{id}?apikey=e2d713ef3c683e06df7d7ea148aef15c&ts=1&hash=f64bede11641777950a218667d1692ad")
    fun getOneHero(@Path("id") id: Int?): Call<Request>

}