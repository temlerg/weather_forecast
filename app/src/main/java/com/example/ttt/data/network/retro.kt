package com.example.ttt.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkService private constructor() {
    private val mRetrofit: Retrofit

    companion object {
        private var mInstance: NetworkService? = null
        private const val BASE_URL = "http://api.openweathermap.org"
        val instance: NetworkService?
            get() {
                if (mInstance == null) {
                    mInstance =
                        NetworkService()
                }
                return mInstance
            }
    }

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getJSONApi(): JSONPlaceHolderApi {
        return mRetrofit.create(JSONPlaceHolderApi::class.java)
    }
}