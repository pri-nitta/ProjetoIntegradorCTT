package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.model.Activities
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.add_task_bsheet_fragment.*


class AddTaskBSheetFragment(private val updateToDoList: () -> Unit) : BottomSheetDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_task_bsheet_fragment, container, false)
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
               Snackbar.make(it, "Tarefa cadastrada com sucesso!", Snackbar.LENGTH_LONG).show()
                redirectRegister(activity)
            }
        }
    }

    fun redirectRegister(activity: Activities){
        MainActivity.toDoListMain.add(activity)
        updateToDoList()
        edtTaskDescB.text = null
        edtTaskTitleB.text = null
        dismiss()
    }
}

