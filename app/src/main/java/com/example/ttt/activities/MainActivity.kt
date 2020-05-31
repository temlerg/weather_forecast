package com.example.ttt.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ttt.R
import com.example.ttt.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}