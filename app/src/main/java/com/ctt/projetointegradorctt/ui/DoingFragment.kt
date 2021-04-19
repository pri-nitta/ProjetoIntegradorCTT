package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.model.DoingAdapter

class DoingFragment: androidx.fragment.app.Fragment() {

    lateinit var doingAdapter: DoingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_doing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvDoing = view.findViewById<RecyclerView>(R.id.doingList)
        doingAdapter = DoingAdapter(MainActivity.doingListMain)
        rvDoing.adapter = doingAdapter
        rvDoing.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        doingAdapter.notifyDataSetChanged()
    }

    private fun updateDoingList(){
        doingAdapter.notifyDataSetChanged()
        updateDoingList()
    }
}