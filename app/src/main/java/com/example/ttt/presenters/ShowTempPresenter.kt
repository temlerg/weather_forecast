package com.example.ttt.presenters

import android.util.Log
import com.example.ttt.R
import com.example.ttt.data.Repository
import com.example.ttt.data.models.Post
import com.example.ttt.views.ShowTempView
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowTempPresenter(private val repository: Repository) : MvpPresenter<ShowTempView>() {

    fun getTemp(city: String) {
        if (city.trim().isEmpty()) {
            viewState.showError(R.string.error_empty_city_input)
            return
        }

        viewState.startSending()

        repository.getTemp(city).enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>, t: Throwable) {
                viewState.endSending()
                viewState.showError(t.message!!)
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                viewState.endSending()

                if (response.isSuccessful) {
                    if (response.body() != null){
                        val temp = repository.getWeatherToday(response.body()!!)
                        if (temp != null)
                            viewState.showSuccess(temp)
                        else
                            viewState.showError("error")
                    }else
                        viewState.showError("error")
                } else {
                    viewState.showError(response.errorBody().toString())
                }
            }
        })
    }
}