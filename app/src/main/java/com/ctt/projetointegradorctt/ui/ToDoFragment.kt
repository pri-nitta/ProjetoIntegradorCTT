package com.ctt.projetointegradorctt.ui

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

class ToDoFragment : androidx.fragment.app.Fragment() {

    lateinit var adapter: ToDoAdapter
    val bottomSheetFragment = AddTaskBSheetFragment(::updateToDoList)
    lateinit var btnAddTask: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvToDo = view.findViewById<RecyclerView>(R.id.toDoList)
        adapter = ToDoAdapter(MainActivity.toDoListMain)
        rvToDo.adapter = adapter
        rvToDo.layoutManager = LinearLayoutManager(requireContext())

        btnAddTask = view.findViewById(R.id.btnAdd)

        btnAddTask.setOnClickListener{
            bottomSheetFragment.show(parentFragmentManager, "BottomSheetDialog")
        }

        //fragment manager mostra onde ele vai aparecer
        //tags para bugs
        //parametros no show
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    private fun updateToDoList(){
        adapter.addTask()
        //mexer no recycler atualizar.
    }
}

