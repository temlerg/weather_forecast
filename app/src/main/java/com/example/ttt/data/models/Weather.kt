package com.example.ttt.data.models

data class WeatherToday(
    val city: String,
    val sea_level: Int,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val temp: Float,
    val humidity: Int,
    val main: String,
    val wind_speed: Float
)
data class WeatherFiveDays(
    val city: String,
    val temp: Float,
    val main: String,
    val dt_txt: String
)