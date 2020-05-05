package com.example.ttt.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Post(
    @SerializedName("Codebeautify")
    @Expose
    val codebeautify: Codebeautify
)

data class Codebeautify(
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
    val list: List<Any> = ArrayList<Any>(),
    @SerializedName("city")
    @Expose
    val city: City?
)

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