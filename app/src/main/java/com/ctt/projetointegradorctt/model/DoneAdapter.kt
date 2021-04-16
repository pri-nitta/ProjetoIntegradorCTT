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

    class DoneAdapter (private val doneList: MutableList<Activities>) : RecyclerView.Adapter<DoneAdapter.DoneHolder>(){
        class DoneHolder(view: View) : RecyclerView.ViewHolder(view) {
            val titleDone: TextView = view.findViewById(R.id.txtToDoTitle)
            val descDone: TextView = view.findViewById(R.id.txtToDoDescr)
            val btnRemovedDone: ImageButton = view.findViewById(R.id.btnRemove)
            val btnChangeStatusDone: ImageButton = view.findViewById(R.id.btnChangeStatus)
        }

        fun addDoneTask() {
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoneHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
            return DoneHolder(view)
        }

        override fun onBindViewHolder(holder: DoneHolder, position: Int) {
            holder.titleDone.text= doneList[position].title
            holder.descDone.text= doneList[position].description
            holder.btnRemovedDone.setOnClickListener{remove(position)}
        }

        fun remove(position: Int) {
            MainActivity.doneListaMain.removeAt(position)
            notifyItemRemoved(position)
        }

        override fun getItemCount(): Int = doneList.size
    }