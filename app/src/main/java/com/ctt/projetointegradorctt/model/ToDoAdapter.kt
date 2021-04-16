package com.ctt.projetointegradorctt.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.MainActivity.Companion.doingListMain
import com.ctt.projetointegradorctt.MainActivity.Companion.toDoListMain
import com.ctt.projetointegradorctt.R
import kotlinx.android.synthetic.main.fragment_to_do.*

class ToDoAdapter(private val toDoList: MutableList<Activities>) : RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {

    class ToDoHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleToDo: TextView = view.findViewById(R.id.txtToDoTitle)
        val descToDo: TextView = view.findViewById(R.id.txtToDoDescr)
        val btnRemoved: ImageButton = view.findViewById(R.id.btnRemove)
        val btnChangeStatus: ImageButton = view.findViewById(R.id.btnChangeStatus)
    }

    fun addTask() {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_to_do, parent, false)
        return ToDoHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        holder.titleToDo.text = toDoList[position].title
        holder.descToDo.text = toDoList[position].description
        holder.btnRemoved.setOnClickListener{remove(position)}
        holder.btnChangeStatus.setOnClickListener{
            changeForDoing(toDoList[position])
            remove(position)
        }
    }

    fun remove(position: Int) {
        toDoListMain.removeAt(position)
        notifyItemRemoved(position)
    }

    fun changeForDoing(activities: Activities){
        doingListMain.add(activities)
    }

    override fun getItemCount(): Int = toDoList.size
}
