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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        city = arguments?.getString(ListFragment.CITY_KEY)
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