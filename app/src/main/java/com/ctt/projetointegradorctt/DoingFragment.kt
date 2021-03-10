package com.ctt.projetointegradorctt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.model.Activities

class DoingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_doing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val doingList = mutableListOf<Activities>(
            Activities(title = "Curso Trello", description = "Terminar curso de Trello", deadline = "01/05")
        )
        val rvDoing = view.findViewById<RecyclerView>(R.id.doingList)
        val adapterDoing = DoingAdapter(doingList)
        rvDoing.adapter = adapterDoing
        rvDoing.layoutManager = LinearLayoutManager(requireContext())
    }

}