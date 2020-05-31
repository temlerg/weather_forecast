package com.example.ttt.data.localDB

import com.example.ttt.utils.constantsDay
import com.example.ttt.utils.constantsTemp

interface SharedPrefDBService {
    fun init()

    fun getSettingDay(): constantsDay

    fun putSettingDay(putConstantsDay: constantsDay)

    fun getSettingTemp(): constantsTemp

    fun putSettingTemp(putConstantsTemp: constantsTemp)
}