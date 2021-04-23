package com.ctt.projetointegradorctt

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.ctt.projetointegradorctt.model.Activities
import com.ctt.projetointegradorctt.model.PagerAdapter
import com.ctt.projetointegradorctt.model.ToDoAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_to_do.*

class MainActivity : AppCompatActivity() {
//    val btnSearch = findViewById<ImageButton>(R.id.btnSearch)
//    val edtSearchTask = findViewById<EditText>(R.id.edtSearchTask3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onResume() {
        super.onResume()

        val textEmpty = findViewById<TextView>(R.id.txtNothingToShow)
        val imgNothing = findViewById<ImageView>(R.id.imgNothing)

//colocar no fragment
        when {
            toDoListMain.isNullOrEmpty() && doingListMain.isNullOrEmpty() && doneListaMain.isNullOrEmpty() -> {
                textEmpty.text = "Vamos adicionar uma nova tarefa?"
                textEmpty.visibility = View.VISIBLE
            }
            doingListMain.isNullOrEmpty() && doneListaMain.isNullOrEmpty() -> {
                textEmpty.text = "Vamos começar a fazer alguma tarefa?"
                textEmpty.visibility = View.VISIBLE
            }
            doneListaMain.isNullOrEmpty() -> {
                textEmpty.text = "Que tal tentar terminar alguma tarefa?"
                textEmpty.visibility = View.VISIBLE
            }
            else -> {
                textEmpty.visibility = View.GONE
                imgNothing.visibility = View.GONE
            }
        }
    }

//    private fun searchTask(){
//        btnSearch.setOnClickListener{
//            if(edtSearchTask == toDoListMain.title)
//        }
//    }

    companion object {
        val toDoListMain = mutableListOf<Activities>()
        val doingListMain = mutableListOf<Activities>()
        val doneListaMain = mutableListOf<Activities>()
    }

}


