package com.example.ttt.data

import com.example.ttt.data.models.Post
import com.example.ttt.data.network.NetworkService
import com.example.ttt.utils.appID
import retrofit2.Call

class Repository {
    fun getTemp(city: String): Call<Post> {
        return NetworkService.getApiRepositories().getPostWithID(city = city, appid = appID)
    }
}