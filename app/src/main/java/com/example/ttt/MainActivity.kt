package com.example.ttt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {
    companion object{
        const val URL = "http://api.openweathermap.org/data/2.5/forecast?q=Moscow&appid=54b2213f4dfeae13b79bbbb1ee45a04b"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a: String
        gorod_edit.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                 //To change body of created functions use File | Settings | File Templates.
                a = s.toString();
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
               //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                 //To change body of created functions use File | Settings | File Templates.
            }
        })
        gorod_edit.setOnClickListener {
            sendCityToServer(getCity())
        }
    }

    private fun sendCityToServer(s: String){
        OkHttpClient()
    }
    private fun getCity() = gorod_edit.text.toString()

}
