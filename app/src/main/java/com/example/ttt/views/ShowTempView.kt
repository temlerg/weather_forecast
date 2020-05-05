package com.example.ttt.views

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface ShowTempView: MvpView {
    fun startSending()

    fun endSending()

    fun showSuccess(temp: String)

    fun showError(error: String)

    fun showError(id: Int)
}