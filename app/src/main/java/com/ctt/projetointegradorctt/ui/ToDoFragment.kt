package com.ctt.projetointegradorctt.ui

import com.ctt.projetointegradorctt.ui.AddTaskBSheetFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.model.ToDoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoFragment : androidx.fragment.app.Fragment() {

    lateinit var adapterTD: ToDoAdapter
    val bsFragmentAddTask = AddTaskBSheetFragment(::updateToDoList)
    lateinit var btnAddTask: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvToDo = view.findViewById<RecyclerView>(R.id.toDoList)
        adapterTD = ToDoAdapter(MainActivity.toDoListMain)
        rvToDo.adapter = adapterTD
        rvToDo.layoutManager = LinearLayoutManager(requireContext())

        btnAddTask = view.findViewById(R.id.btnAdd)
        btnAddTask.setOnClickListener{
            bsFragmentAddTask.show(parentFragmentManager, "BottomSheetDialog")
        }
    }

    override fun onResume() {
        super.onResume()
        adapterTD.notifyDataSetChanged()
    }

    private fun updateToDoList(){
        adapterTD.addTask()
    }
}

