package com.example.ttt.data.network

import com.example.ttt.data.models.Post
import com.example.ttt.utils.appID
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface JSONPlaceHolderApi {
    @GET("/data/2.5/forecast")
    fun getPostWithID(
        @Query("q") city: String,
        @Query("lang") lang: String,
        @Query("appid") appid: String
    ): Call<Post>
}