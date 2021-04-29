package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.projetointegradorctt.MainActivity
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.databinding.FragmentDoingBinding
import com.ctt.projetointegradorctt.model.DoingAdapter

class DoingFragment: androidx.fragment.app.Fragment() {
    lateinit var doingAdapter: DoingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentDoingBinding>(inflater, R.layout.fragment_doing, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvDoing = binding.doingList
        doingAdapter = DoingAdapter(MainActivity.doingListMain)
        rvDoing.adapter = doingAdapter
        rvDoing.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        doingAdapter.notifyDataSetChanged()
        updateScreen2()
    }

    private fun updateScreen2(){
        val textEmpty = binding.txtNothingToShow2
        val imgNothing= binding.imgNothing2

        if (MainActivity.doingListMain.isNullOrEmpty()){
            textEmpty.visibility = View.VISIBLE
            imgNothing.visibility = View.VISIBLE
        }else{
            textEmpty.visibility = View.GONE
            imgNothing.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}