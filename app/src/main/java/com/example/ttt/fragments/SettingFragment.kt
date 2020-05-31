package com.example.ttt.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ttt.R
import com.example.ttt.activities.sistem_set
import com.example.ttt.activities.tupe_set
import com.example.ttt.data.localDB.SharedPrefDB
import com.example.ttt.utils.constantsDay
import com.example.ttt.utils.constantsTemp
import kotlinx.android.synthetic.main.settings_layout.*


class SettingFragment : BaseFragment() {
    companion object {
        const val DIMA_PAGE = "https://github.com/temlerg"
        const val ANDREW_PAGE = "https://github.com/ArlanchikDrey/"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.settings_layout,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView.setOnClickListener {
            tupe_set {
                setDay(it)
            }.show(activity.supportFragmentManager,"settings")
        }
        textView2.setOnClickListener {
            sistem_set{
                setTemp(it)
            }.show(activity.supportFragmentManager,"settings")
        }
        textView14.setOnClickListener {
            openGitHubPage(DIMA_PAGE)
        }
        tv_open_url_andrew.setOnClickListener {
            openGitHubPage(ANDREW_PAGE)
        }
    }

    private fun openGitHubPage(urlParse: String) {
        var url = urlParse
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://$url"
        }
        val openUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (openUrlIntent.resolveActivity(activity.packageManager) != null) {
            startActivity(openUrlIntent)
        }
    }

    private fun setDay(constantsDay: constantsDay){
        SharedPrefDB.putSettingDay(constantsDay)
    }

    private fun setTemp(constantsTemp: constantsTemp){
        SharedPrefDB.putSettingTemp(constantsTemp)
    }
}