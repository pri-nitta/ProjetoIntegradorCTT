package com.ctt.projetointegradorctt.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.R.*
import com.ctt.projetointegradorctt.model.Activities
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class AddBottomSheet : BottomSheetDialogFragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    lateinit var botaoCadastrar: Button
//    lateinit var tituloAct: EditText
//    lateinit var descAct: EditText
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return super.onCreateView(R.layout.bottom_sheet_add_task, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        botaoCadastrar = findViewById(R.id.btnCreateTask)
//        tituloAct = findViewById(R.id.edtTaskTitle)
//        descAct = findViewById(R.id.edtTaskDesc)
//
//        botaoCadastrar.setOnClickListener {
//            val typedTitle = tituloAct.text.toString()
//            val typedDesc = descAct.text.toString()
//            if (typedTitle.isEmpty()) {
//                tituloAct.error = "Digite ao menos um título!"
//            } else {
//                val activity = Activities(typedTitle, typedDesc)
//                redirectRegister(activity)
//            }
//        }
//    }
//
//    fun snackConfirmed(){
//        Snackbar.make(view,"Cadastro realizado com sucesso!", Snackbar.LENGTH_LONG).setAction("Action", null).show()
//    }
//
//    fun redirectRegister(activity: Activities) {
//        MainActivity.toDoListMain.add(activity)
//    }

}


