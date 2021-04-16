package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.model.Activities
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.bottomsheet_fragment.*

class BottomSheetFragment(private val updateToDoList: () -> Unit) : BottomSheetDialogFragment() {
//colocar o add task na frente

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCreateTaskB.setOnClickListener {
            val typedTitle = edtTaskTitleB.text.toString()
            val typedDesc = edtTaskDescB.text.toString()
            if (typedTitle.isEmpty()) {
                edtTaskTitleB.error = "Digite ao menos um título!"
            } else {
                val activity = Activities(typedTitle, typedDesc)
               Snackbar.make(it.rootView, "Tarefa cadastrada com sucesso!", Snackbar.LENGTH_LONG).show()
                redirectRegister(activity)
            }
        }
    }

    fun redirectRegister(activity: Activities){
        MainActivity.toDoListMain.add(activity)
        updateToDoList()
        dismiss()
    }
}

