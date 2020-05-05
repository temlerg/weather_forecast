package com.example.ttt.data

import com.example.ttt.data.models.Post
import com.example.ttt.data.network.NetworkService
import retrofit2.Call

class Repository {
    fun getTemp(city: String): Call<Post>? {
        return NetworkService.instance?.getJSONApi()?.getPostWithID(city)
    }
}