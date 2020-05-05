package com.example.ttt.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface showTempView: MvpView {
    fun startSending()

    fun endSending()

    fun showSuccess(temp: String)

    fun showError(error: String)

    fun showError(id: Int)
}