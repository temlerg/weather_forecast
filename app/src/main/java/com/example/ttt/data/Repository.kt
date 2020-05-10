package com.example.ttt.data

import android.util.Log
import com.example.ttt.data.models.Post
import com.example.ttt.data.models.WeatherToday
import com.example.ttt.data.network.NetworkService
import com.example.ttt.utils.appID
import retrofit2.Call

class Repository {
    fun getTemp(city: String): Call<Post> {
        return NetworkService.getApiRepositories().getPostWithID(city = city, appid = appID)
    }

    fun getWeatherToday(post: Post): WeatherToday? {
        val cityName = post.city?.name
        if (!cityName.isNullOrEmpty())
            return WeatherToday(
                city = cityName,
                main = "",
                humidity = 0,
                temp = 0f,
                temp_max = 0f,
                temp_min = 0f,
                feels_like = 0f,
                sea_level = 0,
                wind_speed = 0f
            )
        else
            return null
    }
}