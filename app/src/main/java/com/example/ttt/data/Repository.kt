package com.example.ttt.data

import com.example.ttt.data.models.Post
import com.example.ttt.data.models.WeatherFiveDays
import com.example.ttt.data.models.WeatherToday
import com.example.ttt.data.network.NetworkService
import com.example.ttt.utils.appID
import retrofit2.Call
import java.text.SimpleDateFormat
import java.util.*

class Repository {
    fun getTemp(city: String): Call<Post> {
        return NetworkService.getApiRepositories().getPostWithID(city = city, appid = appID)
    }

    fun getWeatherToday(post: Post): WeatherToday? {
        val cityName = post.city?.name
        val cod = post.cod
        if (post.list != null) {
            val humidity = post.list[0].main?.humidity
            val temp = post.list[0].main?.temp
            val temp_max = post.list[0].main?.temp_max
            val temp_min = post.list[0].main?.temp_min
            val sea_level = post.list[0].main?.sea_level
            val feels_like = post.list[0].main?.feels_like
            val wind_speed = post.list[0].wind?.speed
            var main: String? = ""

            if (post.list[0].weather != null) {
                main = post.list[0].weather?.get(0)?.main
            }

            if (!cityName.isNullOrEmpty() && humidity != null &&
                temp != null && temp_max != null && temp_min != null
                && sea_level != null && feels_like != null && wind_speed != null
            ) {

                return WeatherToday(
                    cod = cod.toString(),
                    city = cityName,
                    main = main,
                    humidity = humidity,
                    temp = temp,
                    temp_max = temp_max,
                    temp_min = temp_min,
                    feels_like = feels_like,
                    sea_level = sea_level,
                    wind_speed = wind_speed
                )
            } else
                return null
        } else
            return null
    }

    fun getWeatherFiveDays(post: Post): List<WeatherFiveDays>? {
        if (post.list != null) {
            val list = mutableListOf<WeatherFiveDays>()

            for (item in post.list) {
                val temp = item.main?.temp
                var main: String? = ""
                val dt = mapLongTimeToDate(item.dt)

                if (item.weather != null) {
                    main = item.weather[0].main
                }

                if (dt != null &&
                    temp != null
                ) {
                    list.add(
                        WeatherFiveDays(
                            main = main,
                            temp = temp,
                            dt = dt
                        )
                    )
                }
            }
            if (list.size > 0)
                return list
            else
                return null
        } else
            return null
    }

    // example - 25.02 09:03
    fun mapLongTimeToDate(time: Long?): String? {
        if (time != null) {
            val date = Date(time * 1000)
            val format = SimpleDateFormat("dd.MM HH:mm")

            return format.format(date)
        } else
            return null
    }
}