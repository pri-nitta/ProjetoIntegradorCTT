package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ctt.projetointegradorctt.MainActivity.Companion.toDoListMain
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.databinding.FragmentBaseBinding
import com.ctt.projetointegradorctt.databinding.ViewTaskBsheetFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ViewTaskBSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: ViewTaskBsheetFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.view_task_bsheet_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnExclude.setOnClickListener{
        }
        }
//
//        btnStartTask.setOnClickListener{
//            changeForDoing(toDoList[position])
//            remove(it)
//        }
//
//    }
}

fun remove(position: Int) {
    toDoListMain.removeAt(position)
}

fun changeForDoing(activities: View){
//    MainActivity.doingListMain.add(activities)
}
