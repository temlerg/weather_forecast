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
    private var c:String? = null
    private var m:String? = null
    private var w:Float = 0.0f;
    private var fl = 0.0f
    private var h = 0
    private var t = 0.0f
    private var t_max = 0.0f
    private var t_min = 0.0f

    override fun showSuccess(temp: WeatherToday) {
        m = temp.main
        c = temp.city
        fl = temp.feels_like
        h = temp.humidity
        t = temp.temp
        t_max =temp.temp_max
        t_min = temp.temp_min
        w = temp.wind_speed
    }

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

        provideShowTempPresenter().getTemp(c.toString())

        back_city_1_day.setOnClickListener {
            openPage(MainFragment())
        }

        gorod_name_1.setText(c)
        status_w.setText(m)
        temp_teck.setText(t.toString())
        like_temp.setText(fl.toString())
        vlagnoste.setText(h.toString())
        scoroste_vetra.setText(w.toString())
        min_temp.setText(t_min.toString())
        max_temp.setText(t_max.toString())



    }

    override fun startSending() {

    }

    override fun endSending() {
    }


    override fun showSuccess(temp: List<WeatherFiveDays>) {
    }

    override fun showError(error: String) {
    }

    override fun showError(id: Int) {
    }

}