package com.ctt.projetointegradorctt.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.R

    class DoingAdapter (private val doingList: MutableList<Activities>) : RecyclerView.Adapter<DoingAdapter.DoingHolder>(){
        class DoingHolder(view: View) : RecyclerView.ViewHolder(view) {
            val titleDoing: TextView = view.findViewById(R.id.txtToDoTitle)
            val descDoing: TextView = view.findViewById(R.id.txtToDoDescr)
            val btnRemovedDoing: ImageButton = view.findViewById(R.id.btnRemove)
            val btnChangeStatusDone: ImageButton = view.findViewById(R.id.btnChangeStatus)
        }

        fun addDoingTask() {
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoingHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
            return DoingHolder(view)
        }

        override fun onBindViewHolder(holder: DoingHolder, position: Int) {
            holder.descDoing.text= doingList[position].description
            holder.titleDoing.text= doingList[position].title
            holder.btnRemovedDoing.setOnClickListener{remove(position)}
        }

        fun remove(position: Int) {
            MainActivity.toDoListMain.removeAt(position)
            notifyItemRemoved(position)
        }

        override fun getItemCount(): Int = doingList.size
    }