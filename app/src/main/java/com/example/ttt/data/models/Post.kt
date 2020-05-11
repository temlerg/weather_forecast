package com.example.ttt.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Post(
    @SerializedName("cod")
    @Expose
    val cod: String?,
    @SerializedName("message")
    @Expose
    val message: Float = 0f,
    @SerializedName("cnt")
    @Expose
    val cnt: Long = 40,
    @SerializedName("list")
    @Expose
    val list: List<Lists>?,
    @SerializedName("city")
    @Expose
    val city: City?)

data class City(
    @SerializedName("id")
    @Expose
    val id: Float = 0f,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("coord")
    @Expose
    val coord: Coord?,
    @SerializedName("country")
    @Expose
    val country: String?,
    @SerializedName("population")
    @Expose
    val population: Float = 0f,
    @SerializedName("timezone")
    @Expose
    val timezone: Float = 0f,
    @SerializedName("sunrise")
    @Expose
    val sunrise: Float = 0f,
    @SerializedName("sunset")
    @Expose
    val sunset: Float = 0f
)

data class Coord(
    @SerializedName("lat")
    @Expose
    var lat: Float = 0f,
    @SerializedName("lon")
    @Expose
    var lon: Float = 0f
)

data class Lists(
    @SerializedName("dt")
    @Expose
    val dt: Float?,
    @SerializedName("wind")
    @Expose
    val wind: Wind?,
    @SerializedName("main")
    @Expose
    val main: Main?,
    @SerializedName("weather")
    @Expose
    val weather: List<WeatherList>?
)

data class WeatherList(
    @SerializedName("main")
    @Expose
    val main: String?
)

data class Main(
    @SerializedName("sea_level")
    @Expose
    val sea_level: Int,
    @SerializedName("feels_like")
    @Expose
    val feels_like: Float,
    @SerializedName("temp_min")
    @Expose
    val temp_min: Float,
    @SerializedName("temp_max")
    @Expose
    val temp_max: Float,
    @SerializedName("temp")
    @Expose
    val temp: Float,
    @SerializedName("humidity")
    @Expose
    val humidity: Int
)

data class Wind(
    @SerializedName("speed")
    @Expose
    val speed: Float = 0f
)