package com.example.ttt.data.localDB

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.ttt.App
import com.example.ttt.utils.constantsDay
import com.example.ttt.utils.constantsTemp

object SharedPrefDB: SharedPrefDBService{
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferencesEditor: SharedPreferences.Editor

    private const val KEY_TEMP = "temp"
    private const val KEY_DAY = "day"
    private const val TODAY = "today"
    private const val FIVEDAYS = "fivedays"
    const val CENTIGRADE = "CENTIGRADE"
    const val FAHRENHEIT = "FAHRENHEIT"
    const val KELVIN = "KELVIN"

    override fun init() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.instance)
        sharedPreferencesEditor = sharedPreferences.edit()
    }

    override fun getSettingDay(): constantsDay{
        if (sharedPreferences.getString(KEY_DAY, TODAY).equals(TODAY))
            return constantsDay.TODAY
        else
            return constantsDay.FIVEDAYS
    }

    override fun putSettingDay(putConstantsDay: constantsDay){
        if (putConstantsDay == constantsDay.TODAY)
            sharedPreferencesEditor.putString(KEY_DAY,TODAY)
        else
            sharedPreferencesEditor.putString(KEY_DAY,FIVEDAYS)
    }

    override fun getSettingTemp(): constantsTemp {
        val pref = sharedPreferences.getString(KEY_TEMP, KELVIN)
        if (pref.equals(KELVIN))
            return constantsTemp.KELVIN
        else if(pref.equals(FAHRENHEIT))
            return constantsTemp.FAHRENHEIT
        else
            return constantsTemp.CENTIGRADE
    }

    override fun putSettingTemp(putConstantsTemp: constantsTemp) {
        if (putConstantsTemp == constantsTemp.KELVIN)
            sharedPreferencesEditor.putString(KEY_TEMP,KELVIN)
        else if (putConstantsTemp == constantsTemp.FAHRENHEIT)
            sharedPreferencesEditor.putString(KEY_TEMP,FAHRENHEIT)
        else
            sharedPreferencesEditor.putString(KEY_TEMP,CENTIGRADE)
    }
}
