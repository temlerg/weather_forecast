package com.example.ttt.data.localDB

import com.example.ttt.utils.constants

interface SharedPrefDBService {
    fun init()

    fun getSettingDay(): constants

    fun putSettingDay(putConstants: constants)
}