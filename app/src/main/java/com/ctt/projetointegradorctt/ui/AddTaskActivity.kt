package com.ctt.projetointegradorctt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.MainActivity.Companion.toDoListMain
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.model.Activities

class AddTaskActivity: AppCompatActivity() {

lateinit var botaoCadastrar : Button
lateinit var tituloAct : EditText
lateinit var descAct : EditText

    override fun onCreate(savedInstanceState: Bundle?) {super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        botaoCadastrar = findViewById(R.id.btnCreateTask)
        tituloAct = findViewById(R.id.edtTaskTitle)
        descAct = findViewById(R.id.edtTaskDesc)

        botaoCadastrar.setOnClickListener {
            val typedTitle = tituloAct.text.toString()
            val typedDesc = descAct.text.toString()
           if(typedTitle.isEmpty()){
               tituloAct.error ="Digite ao menos um título!"
           } else{
               val activity = Activities(typedTitle,typedDesc)
               toastBtn()
               redirectRegister(activity)
           }
        }
    }

    fun toastBtn(){
        Toast.makeText(this,"Tarefa cadastrada com sucesso!",Toast.LENGTH_SHORT).show()
    }

    fun redirectRegister(activity: Activities){
       toDoListMain.add(activity)
        finish()
    }
}