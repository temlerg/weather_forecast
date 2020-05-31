package com.example.ttt.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.ttt.R
import com.example.ttt.data.Repository
import com.example.ttt.data.models.WeatherFiveDays
import com.example.ttt.data.models.WeatherToday
import com.example.ttt.presenters.ShowTempPresenter
import com.example.ttt.views.ShowTempView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainActivity : MvpAppCompatActivity(), ShowTempView {

    val repository: Repository = Repository()

    @InjectPresenter
    lateinit var showTempPresenter: ShowTempPresenter

    @ProvidePresenter
    fun provideShowTempPresenter(): ShowTempPresenter{
        return ShowTempPresenter(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        search_button.setOnClickListener {
            showTempPresenter.getTemp("Москва")
        }
    }
    
    private fun getCity() = gorod_edit.text.toString()

    override fun startSending() {
        progressBar.visibility = View.VISIBLE
    }

    override fun endSending() {
        progressBar.visibility = View.GONE
    }

    override fun showSuccess(temp: WeatherToday) {
        Toast.makeText(this, temp.toString(), Toast.LENGTH_LONG).show()
    }

    override fun showSuccess(temp: List<WeatherFiveDays>) {
        Log.d("fefvdsv",temp.size.toString())
        Log.d("fefvdsv",temp.toString())
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showError(id: Int) {
        Toast.makeText(this, resources.getString(id), Toast.LENGTH_LONG).show()
    }

}
