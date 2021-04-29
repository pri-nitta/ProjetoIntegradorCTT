package com.ctt.projetointegradorctt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ctt.projetointegradorctt.databinding.ActivityMainBinding
import com.ctt.projetointegradorctt.model.Activities
import com.ctt.projetointegradorctt.model.PagerAdapter
import com.ctt.projetointegradorctt.ui.ViewTaskBSheetFragment
import kotlinx.android.synthetic.main.item_to_do.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val bsFragmentViewTask = ViewTaskBSheetFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        binding.apply {
//            val tabLayout = tabLayout
//            val viewPager = viewPager
//            val edtSearchTask = edtSearchTask3
//        }

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val edtSearchTask = binding.edtSearchTask3
        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        binding.btnSearch.setOnClickListener {
            val typedTask = edtSearchTask.text.toString()
            if (typedTask == txtToDoTitle.text) {
                bsFragmentViewTask.show(supportFragmentManager, "View Task BS")
            } else {
                edtSearchTask.error = (getString(R.string.error_find_task))
            }
        }
    }

    companion object {
        val toDoListMain = mutableListOf<Activities>()
        val doingListMain = mutableListOf<Activities>()
        val doneListaMain = mutableListOf<Activities>()
    }
}


