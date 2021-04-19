package com.ctt.projetointegradorctt

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ctt.projetointegradorctt.model.Activities
import com.ctt.projetointegradorctt.model.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//
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