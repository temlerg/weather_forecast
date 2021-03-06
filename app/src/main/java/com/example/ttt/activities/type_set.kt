package com.example.ttt.activities

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.ttt.utils.constantsDay

class tupe_set(val listener: (constantsDay) -> Unit) : DialogFragment() {

    private val catNames = arrayOf("Прогноз погоды на 1 день", "Прогноз погоды на 5 дней")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val selectedItems = ArrayList<Int>() // Where we track the selected items
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Тип представляемых данных")
                .setSingleChoiceItems(
                    catNames, -1
                ) { dialog, item ->
                    Toast.makeText(
                        activity, "Вы выбрали:  ${catNames[item]}",
                        Toast.LENGTH_SHORT
                    ).show()
                    when (item) {
                        0 -> listener.invoke(constantsDay.TODAY)
                        1 -> listener.invoke(constantsDay.FIVEDAYS)
                    }
                }
                .setPositiveButton("OK") { dialog, id -> }
                .setNegativeButton("Отмена") { dialog, id -> }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}