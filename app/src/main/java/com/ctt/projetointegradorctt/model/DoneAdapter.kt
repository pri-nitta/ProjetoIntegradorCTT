package com.ctt.projetointegradorctt.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.R

    class DoneAdapter (private val doneList: MutableList<Activities>) : RecyclerView.Adapter<DoneAdapter.DoneHolder>(){
        class DoneHolder(view: View) : RecyclerView.ViewHolder(view) {
            val titleDone: TextView = view.findViewById(R.id.txtDoneTitle)
            val descDone: TextView = view.findViewById(R.id.txtDoneDescription)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoneHolder {
            val view = LayoutInflater.from(parent.context).
            inflate(R.layout.item_done, parent, false)
            return DoneHolder(view)
        }

        override fun onBindViewHolder(holder: DoneHolder, position: Int) {
            holder.titleDone.text= doneList[position].title
            holder.descDone.text= doneList[position].description
        }

        override fun getItemCount(): Int = doneList.size
    }