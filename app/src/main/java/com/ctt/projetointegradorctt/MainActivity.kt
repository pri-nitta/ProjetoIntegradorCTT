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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    companion object {
        val toDoListMain = mutableListOf<Activities>()
        val doingListMain = mutableListOf<Activities>()
        val doneListaMain = mutableListOf<Activities>()
    }
}


