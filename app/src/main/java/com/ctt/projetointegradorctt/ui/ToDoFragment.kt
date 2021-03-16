package com.ctt.projetointegradorctt.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.MainActivity.Companion.toDoListMain
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.model.Activities
import com.ctt.projetointegradorctt.model.ToDoAdapter
import kotlinx.android.synthetic.main.fragment_to_do.*

class ToDoFragment : Fragment() {

    lateinit var adapter: ToDoAdapter
    lateinit var btnSearchTask: Button
    lateinit var edtSearchTaskTyped: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val toDoListNew: MutableList<Activities> = mutableListOf(
//            Activities(title = "Exercícios do Hacker Rank", description = "Terminar lista de lógica"),
//            Activities(title = "Skin care", description = "Passar ácido glicólico todas as noites")
//        )

        MainActivity.toDoListMain.add(Activities())

        val rvToDo = view.findViewById<RecyclerView>(R.id.toDoList)
        adapter = ToDoAdapter(MainActivity.toDoListMain)
        rvToDo.adapter = adapter
        rvToDo.layoutManager = LinearLayoutManager(requireContext())

        btnSearchTask = view.findViewById(R.id.btnSearch1)
        edtSearchTaskTyped = view.findViewById(R.id.edtSearchTask1)

        val titulo = edtSearchTaskTyped.text.toString()

        btnSearchTask.setOnClickListener {
                if (toDoListMain.contains(edtSearchTaskTyped)) {
                    val intent2 = Intent(MainActivity(), ViewTaskActivity::class.java)
                    MainActivity().startActivity(intent2)
                }else {
                    edtSearchTaskTyped.error = "Atividade não encontrada :("
                }
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}