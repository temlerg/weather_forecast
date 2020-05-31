package com.example.ttt.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ttt.R
import com.example.ttt.data.localDB.SharedPrefDB
import com.example.ttt.utils.constantsDay
import kotlinx.android.synthetic.main.activity_main_fragment.*

class MainFragment: BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.activity_main_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_button.setOnClickListener {
            if(SharedPrefDB.getSettingDay() == constantsDay.TODAY){
                openPage(OneDayFragment.getInstance("Moscow"))
            }else{
                openPage(ListFragment.getInstance("Moscow"))
            }
        }

        settings.setOnClickListener {
            openPage(SettingFragment())
        }
    }

    /*
   тут должна быть часть кода, когда у нас введен не правильный город, и вернась ошибка на запрос, то выводим диалоговое окно diolog_error
    */
    private fun openPage(fragment: BaseFragment){
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack("")
            .commit()
    }
    private fun getCity() = gorod_edit.text.toString()
}