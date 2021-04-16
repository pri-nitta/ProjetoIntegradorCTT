package com.ctt.projetointegradorctt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ctt.projetointegradorctt.model.Activities
import com.ctt.projetointegradorctt.model.PagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    companion object {
        val toDoListMain = mutableListOf<Activities>()
        val doingListMain = mutableListOf<Activities>()
        val doneListaMain = mutableListOf<Activities>()
    }
}