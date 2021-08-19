package com.example.theappviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyview_layout.view.*

class RecViewAdapter : RecyclerView.Adapter<RecViewAdapter.ViewHolder>() {

    private val carName = arrayOf("Car1", "Car2", "Car3", "Car4", "Car5")

    private val carDetails = arrayOf("car1", "car2", "car3", "car4", "car5")

    private val image = intArrayOf(R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4,
        R.drawable.car5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyview_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return carName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.car_name.text = carName[position]
        holder.itemView.car_details.text = carDetails[position]
        holder.itemView.car_image.setImageResource(image[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {


                Toast.makeText(itemView.context, itemView.car_name.text,  Toast.LENGTH_SHORT).show()


            }
        }
    }

}
