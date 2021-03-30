package com.ctt.projetointegradorctt.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.model.ToDoAdapter

class ToDoFragment : androidx.fragment.app.Fragment() {

    lateinit var adapter: ToDoAdapter
//    lateinit var btnSearchTask: Button
    lateinit var edtSearchTaskTyped: EditText
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
//        btnSearchTask = view.findViewById(R.id.btnSearch1)
        edtSearchTaskTyped = view.findViewById(R.id.edtSearchTask1)
//        btnRemoved = view.findViewById(R.id.BtnRemove)

        val titulo = edtSearchTaskTyped.text.toString()

        btnAddTask.setOnClickListener{
            val intent3 = Intent(requireActivity(), AddTaskActivity::class.java)
            requireActivity().startActivity(intent3)
        }

//        btnRemoved.setOnClickListener{
//            toDoListMain.remove(it)
//        }

//        btnSearchTask.setOnClickListener {
//            if (toDoListMain.any{it.title == titulo}) {
//                val intent2 = Intent(MainActivity(), ViewTaskActivity::class.java)
//                MainActivity().startActivity(intent2)
//            } else {
//                edtSearchTaskTyped.error = "Atividade não encontrada :("
//            }
//        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}

