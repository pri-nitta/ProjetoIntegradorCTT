package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.MainActivity.Companion.toDoListMain
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.databinding.FragmentToDoBinding
import com.ctt.projetointegradorctt.model.ToDoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ToDoFragment : androidx.fragment.app.Fragment() {

    lateinit var adapterTD: ToDoAdapter
    val bsFragmentAddTask = AddTaskBSheetFragment(::updateToDoList)
    private lateinit var binding: FragmentToDoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterTD = ToDoAdapter(toDoListMain)
        binding.toDoList.adapter = adapterTD
        binding.toDoList.layoutManager = LinearLayoutManager(requireContext())

        binding.btnAdd.setOnClickListener{
            bsFragmentAddTask.show(parentFragmentManager, "BottomSheetDialog")
        }
    }

    override fun onResume() {
        super.onResume()
        adapterTD.notifyDataSetChanged()
        updateScreen()
    }

    private fun updateToDoList(){
        Snackbar.make(requireView(), getString(R.string.snack_task_registered_confirmation), Snackbar.LENGTH_LONG).show()
        adapterTD.addTask()
        adapterTD.notifyDataSetChanged()
        updateScreen()
    }

    fun updateScreen(){
        if (toDoListMain.isNullOrEmpty()){
            binding.txtNothingToShow.visibility = View.VISIBLE
            binding.imgNothing.visibility = View.VISIBLE
        }else{
            binding.txtNothingToShow.visibility = View.GONE
            binding.imgNothing.visibility = View.GONE
        }
    }
}

