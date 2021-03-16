package com.ctt.projetointegradorctt
import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.model.Activities
import com.ctt.projetointegradorctt.model.ToDoAdapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_to_do.*

class ToDoFragment : Fragment() {

    lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View? {
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toDoListNew: MutableList<Activities> = mutableListOf(
            Activities(title = "Exercícios do Hacker Rank", description = "Terminar lista de lógica"),
            Activities(title = "Skin care", description = "Passar ácido glicólico todas as noites")
        )

        MainActivity.toDoListMain.add(Activities())

        val rvToDo = view.findViewById<RecyclerView>(R.id.toDoList)
        adapter = ToDoAdapter(MainActivity.toDoListMain)
        rvToDo.adapter = adapter

        rvToDo.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}