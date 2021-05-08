package com.ctt.projetointegradorctt.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ctt.projetointegradorctt.model.Activities

class ToDoViewModel : ViewModel() {

    private val _toDoList = MutableLiveData<Activities>()
    val toDoList: LiveData<Activities>
        get() = _toDoList
}