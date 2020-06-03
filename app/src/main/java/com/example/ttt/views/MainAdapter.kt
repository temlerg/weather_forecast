package com.example.ttt.views

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ttt.R
import com.example.ttt.data.localDB.SharedPrefDB
import com.example.ttt.data.models.WeatherFiveDays
import com.example.ttt.utils.constantsTemp

class MainAdapter(var items: List<WeatherFiveDays>) :
    RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycle_item, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val status = itemView.findViewById<TextView>(R.id.status_for_5)
        private val temp = itemView.findViewById<TextView>(R.id.temp_for_5)
        private val time = itemView.findViewById<TextView>(R.id.time_for_5)
        private val ic = itemView.findViewById<ImageView>(R.id.ic_for_5)

        @SuppressLint("SetTextI18n")
        fun bind(item: WeatherFiveDays) {


            if (item.main == "Clear") {
                status.setText("Ясно")
                ic.setImageResource(R.drawable.solnichko)
            } else if (item.main == "Rain") {
                status.setText("Дождь")
                ic.setImageResource(R.drawable.zont)
            } else if (item.main == "Clouds") {
                status.setText("Облачно")
                ic.setImageResource(R.drawable.mnogo_oblocshov)
            }

            if (SharedPrefDB.getSettingTemp() == constantsTemp.KELVIN) {
                temp.setText((item.temp).toInt().toString() + " K")
            } else if (SharedPrefDB.getSettingTemp() == constantsTemp.CENTIGRADE) {
                temp.setText((item.temp - 273).toInt().toString() + " ℃")
            } else {
                temp.setText(((item.temp - 273) * 9 / 5 + 32).toInt().toString() + " ℉")
            }

            //status.text = item.main
            //temp.text = item.temp.toString()
            time.text = item.dt
        }
    }
}