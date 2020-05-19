package com.glowingsoft.recyclerviewkotlinexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val userlist: ArrayList<User>, var callback: Callback) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvItem = itemView.findViewById(R.id.layout) as LinearLayout
        fun bindItems(user: User) {
            val textViewName = itemView.findViewById(R.id.txt1) as TextView
            val textViewAddress = itemView.findViewById(R.id.txt2) as TextView
            textViewName.text = user.name
            textViewAddress.text = user.address
            initClickListeners()
        }

        private fun initClickListeners() {
            cvItem.setOnClickListener {
                callback.onItemClicked(adapterPosition)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lat_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userlist[position])
    }


    interface Callback {
        fun onItemClicked(pos: Int)
    }
}