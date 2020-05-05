package com.example.ttt.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.ttt.R
import com.example.ttt.data.Repository
import com.example.ttt.data.models.Post
import com.example.ttt.views.showTempView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class ShowTempPresenter(private val repository: Repository): MvpPresenter<showTempView>() {

    fun getTemp(city: String) {
        if (city.trim().isEmpty()){
            viewState.showError(R.string.error_empty_city_input)
            return
        }

        viewState.startSending()

        repository.getTemp(city)?.enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>, t: Throwable) {
                viewState.endSending()
                viewState.showError(t.message!!)
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                viewState.endSending()

                if (response.isSuccessful){
                    val temp = ""
                    viewState.showSuccess(temp)
                }
            }
        })
    }
}