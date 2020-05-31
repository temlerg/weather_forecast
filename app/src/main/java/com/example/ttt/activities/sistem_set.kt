package com.example.ttt.activities

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.ttt.utils.constantsTemp

class sistem_set(val listener: (constantsTemp) -> Unit) : DialogFragment() {

    private val catNames = arrayOf("Цельсия", "Фарренгейта", "Кульвина")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val selectedItems = ArrayList<Int>() // Where we track the selected items
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Система измерения температуры")
                .setSingleChoiceItems(
                    catNames, -1
                ) { dialog, item ->
                    Toast.makeText(
                        activity, "Система измерения:  ${catNames[item]}",
                        Toast.LENGTH_SHORT
                    ).show()
                    when (item) {
                        0 -> listener.invoke(constantsTemp.CENTIGRADE)
                        1 -> listener.invoke(constantsTemp.FAHRENHEIT)
                        2 -> listener.invoke(constantsTemp.KELVIN)
                    }
                }
                .setPositiveButton(
                    "OK"
                ) { dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    // or return them to the component that opened the dialog
                }
                .setNegativeButton("Отмена") { dialog, id ->
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
