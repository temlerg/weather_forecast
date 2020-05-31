package com.example.ttt.activities

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class sistem_set : DialogFragment() {

    private val catNames = arrayOf("Цельсия", "Фарренгейта", "Кульвина")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val selectedItems = ArrayList<Int>() // Where we track the selected items
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Система измерения температуры")
                .setSingleChoiceItems(catNames, -1
                ) { dialog, item ->
                    Toast.makeText(activity, "Система измерения:  ${catNames[item]}",
                        Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("OK"
                ) { dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    // or return them to the component that opened the dialog
                }
                .setNegativeButton("Отмена") {
                        dialog, id ->
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
