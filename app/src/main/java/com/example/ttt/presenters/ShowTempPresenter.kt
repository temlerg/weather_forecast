package com.example.ttt.presenters

import android.util.Log
import com.example.ttt.R
import com.example.ttt.data.Repository
import com.example.ttt.data.localDB.SharedPrefDB
import com.example.ttt.data.models.Post
import com.example.ttt.utils.constantsDay
import com.example.ttt.views.ShowTempView
import moxy.MvpPresenter
import org.json.JSONObject
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
                    if (response.body() != null) {

                        val temp_one = repository.getWeatherToday(response.body()!!)
                        if (temp_one != null)
                            viewState.showSuccess(temp_one)
                        else
                            viewState.showError("error")
                        val temp_5 = repository.getWeatherFiveDays(response.body()!!)
                        if (temp_5 != null)
                            viewState.showSuccess(temp_5)
                        else
                            viewState.showError("error")

                    } else
                        viewState.showError("error")
                } else if (response.errorBody() != null) {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    val error = jObjError.getString("message")
                    viewState.showError(error)
                }
            }
        })
    }
}