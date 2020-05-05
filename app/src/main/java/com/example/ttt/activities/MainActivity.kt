package com.example.ttt.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.ttt.R
import com.example.ttt.data.Repository
import com.example.ttt.presenters.ShowTempPresenter
import com.example.ttt.views.showTempView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), showTempView {

    val repository: Repository = Repository()

    @InjectPresenter(presenterId = "", tag = "", type = PresenterType.GLOBAL)
    lateinit var showTempPresenter: ShowTempPresenter

    @ProvidePresenter
    fun provideShowTempPresenter(): ShowTempPresenter{
        return ShowTempPresenter(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showTempPresenter.getTemp("Moscow")
    }
    
    private fun getCity() = gorod_edit.text.toString()

    override fun startSending() {
        progressBar.visibility = View.VISIBLE
    }

    override fun endSending() {
        progressBar.visibility = View.GONE
    }

    override fun showSuccess(temp: String) {
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showError(id: Int) {
        Toast.makeText(this, resources.getString(id), Toast.LENGTH_LONG).show()
    }

}
