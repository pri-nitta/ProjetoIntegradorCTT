package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.MainActivity.Companion.toDoListMain
import com.ctt.projetointegradorctt.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.item_to_do.*

class ViewTaskBSheetFragment : BottomSheetDialogFragment() {
    lateinit var btnDeleteTask: ImageButton
    lateinit var btnStartTask: Button
    lateinit var bntEdit: Button
    lateinit var taskTitle: TextView
//    lateinit var taskStatus: TextView
    lateinit var taskDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
//
//        taskTitle = txtToDoTitle
//        taskDescription = txtToDoDescr
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_task_bsheet_fragment, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        btnDeleteTask.setOnClickListener{
//            remove(position)
//        }
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
