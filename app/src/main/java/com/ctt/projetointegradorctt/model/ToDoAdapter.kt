package com.ctt.projetointegradorctt.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.R

class ToDoAdapter (private val toDoList: MutableList<Activities>) : RecyclerView.Adapter<ToDoAdapter.ToDoHolder>(){
    class ToDoHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleToDo: TextView = view.findViewById(R.id.txtActTitle)
        val deadlineToDo: TextView = view.findViewById(R.id.txtDeadline)
        val priorityToDo: ImageView = view.findViewById(R.id.txtPriority)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_to_do, parent, false)
        return ToDoHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        holder.titleToDo.text= toDoList[position].title
        holder.deadlineToDo.text= toDoList[position].deadline
        holder.priorityToDo.text= toDoList[position].priority
    }

    override fun getItemCount(): Int = toDoList.size
}