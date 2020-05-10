package com.example.ttt.views

import com.example.ttt.data.models.WeatherFiveDays
import com.example.ttt.data.models.WeatherToday
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface ShowTempView: MvpView {
    fun startSending()

    fun endSending()

    fun showSuccess(temp: WeatherToday)

    fun showSuccess(temp: WeatherFiveDays)

    fun showError(error: String)

    fun showError(id: Int)
}