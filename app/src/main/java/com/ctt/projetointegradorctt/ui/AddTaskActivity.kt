package com.ctt.projetointegradorctt.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.MainActivity.Companion.toDoListMain
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.model.Activities
import kotlinx.android.synthetic.main.fragment_to_do.*

class AddTaskActivity: AppCompatActivity() {

    private lateinit var botaoCadastrar : Button
    private lateinit var tituloAct : EditText
    private lateinit var descAct : EditText

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        botaoCadastrar = findViewById<Button>(R.id.btnCreateTask)
        tituloAct = findViewById(R.id.edtTaskTitle)
        descAct = findViewById(R.id.edtTaskDesc)

        botaoCadastrar.setOnClickListener {
            val typedTitle = tituloAct.text.toString()
            val typedDesc = descAct.text.toString()
           if(typedTitle.isEmpty()){
               tituloAct.error ="Digite um título!"
           } else{
               val register = Activities(typedTitle,typedDesc)
               val activity = Activities(typedTitle,typedDesc)
               actionBtn()
               redirectRegister(activity)
           }
        }
    }

    fun actionBtn(){
        Toast.makeText(this,"Tarefa cadastrada com sucesso!",Toast.LENGTH_SHORT).show()
    }

    fun redirectRegister(activity: Activities){
        MainActivity.toDoListMain.add(activity)
        finish()
    }
}