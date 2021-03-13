package com.ctt.projetointegradorctt.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.R

    class DoingAdapter (private val doingList: MutableList<Activities>) : RecyclerView.Adapter<DoingAdapter.DoingHolder>(){
        class DoingHolder(view: View) : RecyclerView.ViewHolder(view) {
            val titleDoing: TextView = view.findViewById(R.id.txtDoingTitle)
            val descDoing: ImageView = view.findViewById(R.id.txtDoingDescription)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoingHolder {
            val view = LayoutInflater.from(parent.context).
            inflate(R.layout.item_to_do, parent, false)
            return DoingHolder(view)
        }

        override fun onBindViewHolder(holder: DoingHolder, position: Int) {
            holder.titleDoing.text= doingList[position].title
            holder.descDoing.text= doingList[position].description
        }

        override fun getItemCount(): Int = doingList.size
    }
}
}