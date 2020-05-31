package com.example.ttt.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ttt.R
import com.example.ttt.activities.dialog_erroe
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
            if (getCity().isEmpty()){
                dialog_erroe().show(activity.supportFragmentManager,"dialog")
            }else {
                if (SharedPrefDB.getSettingDay() == constantsDay.TODAY) {
                    openPage(OneDayFragment.getInstance(getCity()))
                } else {
                    openPage(ListFragment.getInstance(getCity()))
                }
            }
        }

        settings.setOnClickListener {
            openPage(SettingFragment())
        }
    }

    private fun openPage(fragment: BaseFragment){
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack("")
            .commit()
    }
    private fun getCity() = gorod_edit.text.toString()
}