package com.example.ttt.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ttt.R
import com.example.ttt.activities.dialog_erroe
import com.example.ttt.data.Repository
import com.example.ttt.data.localDB.SharedPrefDB
import com.example.ttt.data.models.WeatherFiveDays
import com.example.ttt.data.models.WeatherToday
import com.example.ttt.presenters.ShowTempPresenter
import com.example.ttt.utils.constantsTemp
import com.example.ttt.views.ShowTempView
import kotlinx.android.synthetic.main.for_one_day.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class OneDayFragment private constructor() : BaseFragment(), ShowTempView {
    val repository: Repository = Repository()
    private var city: String? = null

    @InjectPresenter
    lateinit var showTempPresenter: ShowTempPresenter

    @ProvidePresenter
    fun provideShowTempPresenter(): ShowTempPresenter {
        return ShowTempPresenter(repository)
    }

    companion object {
        const val CITY_KEY = "city"

        fun getInstance(city: String): OneDayFragment {
            val fragment = OneDayFragment()
            val args = Bundle()
            args.putString(CITY_KEY, city)
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

    private fun openPage(fragment: BaseFragment) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack("")
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        city = arguments?.getString(CITY_KEY)

        back_city_1_day.setOnClickListener {
            openPage(MainFragment())
        }

        showTempPresenter.getTemp(city.toString())
    }

    override fun startSending() {
    }

    override fun endSending() {
    }

    @SuppressLint("SetTextI18n")
    override fun showSuccess(temp: WeatherToday) {
        gorod_name_1.text = temp.city

        if (temp.main == "Clear") {
            status_w.text = "Ясно"
            image.setImageResource(R.drawable.solnichko)
        } else if (temp.main == "Rain") {
            status_w.text = "Дождь"
            image.setImageResource(R.drawable.zont)


        } else if (temp.main == "Clouds") {
            status_w.text = "Облачно"
            image.setImageResource(R.drawable.mnogo_oblocshov)
        }

        if (SharedPrefDB.getSettingTemp() == constantsTemp.KELVIN) {
            max_temp.text = (temp.temp_max).toInt().toString() + " K"
            min_temp.text = (temp.temp_min).toInt().toString() + " K"
            temp_teck.text = (temp.temp).toInt().toString() + " K"
            like_temp.text = (temp.feels_like).toInt().toString() + " K"
        } else if (SharedPrefDB.getSettingTemp() == constantsTemp.CENTIGRADE) {
            max_temp.text = (temp.temp_max - 273).toInt().toString() + " ℃"
            min_temp.text = (temp.temp_min - 273).toInt().toString() + " ℃"
            temp_teck.text = (temp.temp - 273).toInt().toString() + " ℃"
            like_temp.text = (temp.feels_like - 273).toInt().toString() + " ℃"
        } else {
            max_temp.text = ((temp.temp_max - 273) * 9 / 5 + 32).toInt().toString() + " ℉"
            min_temp.text = ((temp.temp_min - 273) * 9 / 5 + 32).toInt().toString() + " ℉"
            temp_teck.text = ((temp.temp - 273) * 9 / 5 + 32).toInt().toString() + " ℉"
            like_temp.text = ((temp.feels_like - 273) * 9 / 5 + 32).toInt().toString() + " ℉"
        }
        vlagnoste.text = temp.humidity.toString() + "%"
        scoroste_vetra.text = temp.wind_speed.toString() + "м/с"

    }

    @SuppressLint("SetTextI18n")
    override fun showSuccess(temp: List<WeatherFiveDays>) {

        if (temp[0].main == "Clear") stat_3.text = "Ясно"
        else if (temp[0].main == "Rain") stat_3.text = "Дождь"
        else if (temp[0].main == "Clouds") stat_3.text = "Облачно"

        if (temp[1].main == "Clear") stat_6.text = "Ясно"
        else if (temp[1].main == "Rain") stat_6.text = "Дождь"
        else if (temp[1].main == "Clouds") stat_6.text = "Облачно"

        if (temp[3].main == "Clear") stat_9.text = "Ясно"
        else if (temp[2].main == "Rain") stat_9.text = "Дождь"
        else if (temp[2].main == "Clouds") stat_9.text = "Облачно"

        if (temp[3].main == "Clear") stat_12.text = "Ясно"
        else if (temp[3].main == "Rain") stat_12.text = "Дождь"
        else if (temp[3].main == "Clouds") stat_12.text = "Облачно"


        if (SharedPrefDB.getSettingTemp() == constantsTemp.KELVIN) {
            temp_3.text = (temp[0].temp).toInt().toString() + " K"
            temp_6.text = (temp[1].temp).toInt().toString() + " K"
            temp_9.text = (temp[2].temp).toInt().toString() + " K"
            temp_12.text = (temp[3].temp).toInt().toString() + " K"
        } else if (SharedPrefDB.getSettingTemp() == constantsTemp.CENTIGRADE) {
            temp_3.text = (temp[0].temp - 273).toInt().toString() + " ℃"
            temp_6.text = (temp[1].temp - 273).toInt().toString() + " ℃"
            temp_9.text = (temp[2].temp - 273).toInt().toString() + " ℃"
            temp_12.text = (temp[3].temp - 273).toInt().toString() + " ℃"
        } else {
            temp_3.text = ((temp[0].temp - 273) * 9 / 5 + 32).toInt().toString() + " ℉"
            temp_6.text = ((temp[1].temp - 273) * 9 / 5 + 32).toInt().toString() + " ℉"
            temp_9.text = ((temp[2].temp - 273) * 9 / 5 + 32).toInt().toString() + " ℉"
            temp_12.text = ((temp[3].temp - 273) * 9 / 5 + 32).toInt().toString() + " ℉"
        }

        time_3.text = temp[0].dt
        time_6.text = temp[1].dt
        time_9.text = temp[2].dt
        time_12.text = temp[3].dt
    }

    override fun showError(error: String) {
        if (error == "city not found") {
            dialog_erroe().show(activity.supportFragmentManager, "dialog")
        }
    }

    override fun showError(id: Int) {
    }

}