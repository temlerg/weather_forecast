package com.example.ttt.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ttt.R
import com.example.ttt.data.Repository
import com.example.ttt.data.models.WeatherFiveDays
import com.example.ttt.data.models.WeatherToday
import com.example.ttt.presenters.ShowTempPresenter
import com.example.ttt.views.ShowTempView
import kotlinx.android.synthetic.main.for_5_day.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class ListFragment private constructor() : BaseFragment(), ShowTempView {
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

        fun getInstance(city: String): ListFragment {
            val fragment = ListFragment()
            val args = Bundle()
            args.putString(CITY_KEY, city)
            fragment.arguments = args
            return fragment
        }
    }

    private fun openPage(fragment: BaseFragment) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack("")
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.for_5_day,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        city = arguments?.getString(CITY_KEY)

        back_city_5_day.setOnClickListener {
            openPage(MainFragment())
        }
    }

    override fun startSending() {

    }

    override fun endSending() {
    }

    override fun showSuccess(temp: WeatherToday) {
    }

    override fun showSuccess(temp: List<WeatherFiveDays>) {
    }

    override fun showError(error: String) {
    }

    override fun showError(id: Int) {
    }

}