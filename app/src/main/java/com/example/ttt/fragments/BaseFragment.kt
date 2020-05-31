package com.example.ttt.fragments

import android.content.Context
import com.example.ttt.activities.MainActivity
import moxy.MvpAppCompatFragment

open class BaseFragment : MvpAppCompatFragment() {
    protected lateinit var activity: MainActivity
    protected var TAG = this::class.java.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)

        activity = context as MainActivity
    }
}
