package com.example.ttt.data.localDB

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.ttt.App
import com.example.ttt.utils.constants

object SharedPrefDB: SharedPrefDBService{
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferencesEditor: SharedPreferences.Editor

    private const val TODAY = "today"
    private const val FIVEDAYS = "fivedays"

    override fun init() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.instance)
        sharedPreferencesEditor = sharedPreferences.edit()
    }

    override fun getSettingDay(): constants{
        if (sharedPreferences.getString("day", TODAY).equals(TODAY))
            return constants.TODAY
        else
            return constants.FIVEDAYS
    }

    override fun putSettingDay(putConstants: constants){
        if (putConstants == constants.TODAY)
            sharedPreferencesEditor.putString("day",TODAY)
        else
            sharedPreferencesEditor.putString("day",FIVEDAYS)
    }
}
