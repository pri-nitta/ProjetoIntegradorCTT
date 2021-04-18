package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ctt.projetointegradorctt.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EditTaskBSheetFragment(private val updateList: () -> Unit) : BottomSheetDialogFragment()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_task_bsheet_fragment, container, false)
    }
}