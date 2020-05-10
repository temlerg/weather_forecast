package com.example.ttt.data.network

import com.example.ttt.data.models.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface JSONPlaceHolderApi {
    @GET("/data/2.5/forecast?q={city}&appid=54b2213f4dfeae13b79bbbb1ee45a04b")
    fun getPostWithID(@Path("city") city: String): Call<Post>
}