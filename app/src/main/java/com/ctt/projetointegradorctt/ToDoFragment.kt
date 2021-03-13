package com.ctt.projetointegradorctt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.model.Activities
import com.ctt.projetointegradorctt.model.ToDoAdapter

class ToDoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toDoList = mutableListOf<Activities>(
            Activities(title = "Curso Trello", description = "afferson")
        )
        val rvToDo = view.findViewById<RecyclerView>(R.id.toDoList)
        val adapterToDo = ToDoAdapter(toDoList)
        rvToDo.adapter = adapterToDo
        rvToDo.layoutManager = LinearLayoutManager(requireContext())
    }
}