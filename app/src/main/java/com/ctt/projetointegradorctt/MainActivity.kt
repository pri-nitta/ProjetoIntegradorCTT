package com.ctt.projetointegradorctt

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.ctt.projetointegradorctt.model.Activities
import com.ctt.projetointegradorctt.model.PagerAdapter
import com.ctt.projetointegradorctt.model.ToDoAdapter
import com.ctt.projetointegradorctt.ui.ViewTaskBSheetFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_to_do.*
import kotlinx.android.synthetic.main.item_template.*
import kotlinx.android.synthetic.main.item_to_do.*

class MainActivity : AppCompatActivity() {
    lateinit var btnSearch: ImageButton
    lateinit var edtSearchTask: EditText
    val bsFragmentViewTask = ViewTaskBSheetFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        edtSearchTask = findViewById(R.id.edtSearchTask3)
        btnSearch = findViewById(R.id.btnSearch)
        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        btnSearch.setOnClickListener {
            val typedTask = edtSearchTask.text.toString()
            if (typedTask == txtToDoTitle.text || typedTask == txtTitle.text) {
                bsFragmentViewTask.show(supportFragmentManager,"View Task BS")
            }else{
                edtSearchTask.error=("Atividade não encontrada!")
            }
        }
    }

    companion object {
        val toDoListMain = mutableListOf<Activities>()
        val doingListMain = mutableListOf<Activities>()
        val doneListaMain = mutableListOf<Activities>()
    }

}


