package com.example.ttt.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ttt.R
import com.example.ttt.data.Repository
import com.example.ttt.data.models.Main
import com.example.ttt.data.models.Post
import com.example.ttt.data.models.WeatherFiveDays
import com.example.ttt.data.models.WeatherToday
import com.example.ttt.presenters.ShowTempPresenter
import com.example.ttt.views.ShowTempView
import kotlinx.android.synthetic.main.for_one_day.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class OneDayFragment private constructor(): BaseFragment(), ShowTempView {
    val repository: Repository = Repository()
    private var city: String? = null

    @InjectPresenter
    lateinit var showTempPresenter: ShowTempPresenter

    @ProvidePresenter
    fun provideShowTempPresenter(): ShowTempPresenter {
        return ShowTempPresenter(repository)
    }

    companion object{
        const val CITY_KEY = "city"

        fun getInstance(city: String): OneDayFragment {
            val fragment = OneDayFragment()
            val args = Bundle()
            args.putString(CITY_KEY,city)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.for_one_day,
            container,
            false
        )

    }
    private fun openPage(fragment: BaseFragment){
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack("")
            .commit()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        city = arguments?.getString(ListFragment.CITY_KEY)

        provideShowTempPresenter().getTemp(city.toString())

        back_city_1_day.setOnClickListener {
            openPage(MainFragment())
        }

    }

    override fun startSending() {

    }

    override fun endSending() {
    }

    override fun showSuccess(temp: WeatherToday) {
        gorod_name_1.setText(temp.city)
        status_w.setText(temp.main)
        max_temp.setText(temp.temp_max.toString())
        min_temp.setText(temp.temp_min.toString())
        temp_teck.setText(temp.temp.toString())
        like_temp.setText(temp.feels_like.toString())
        vlagnoste.setText(temp.humidity.toString()+"%")
        scoroste_vetra.setText(temp.wind_speed.toString()+"м/с")
    }

    override fun showSuccess(temp: List<WeatherFiveDays>) {
    }

    override fun showError(error: String) {
    }

    override fun showError(id: Int) {
    }

}