package com.example.ttt

import android.annotation.SuppressLint
import android.app.Application
import com.example.ttt.data.localDB.SharedPrefDB

class App: Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    @SuppressLint("CommitPrefEdits")
    override fun onCreate() {
        super.onCreate()
        instance = this
        SharedPrefDB.init()
    }
}