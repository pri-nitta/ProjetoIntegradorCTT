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
import com.ctt.projetointegradorctt.databinding.ActivityMainBinding
import com.ctt.projetointegradorctt.databinding.FragmentDoingBinding
import com.ctt.projetointegradorctt.model.DoingAdapter

class DoingFragment: androidx.fragment.app.Fragment() {
    lateinit var doingAdapter: DoingAdapter
    private lateinit var binding: FragmentDoingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_doing, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doingAdapter = DoingAdapter(MainActivity.doingListMain)
        binding.doingList.adapter = doingAdapter
        binding.doingList.layoutManager = LinearLayoutManager(requireContext())
        updateScreen2()
    }

    override fun onResume() {
        super.onResume()
        doingAdapter.notifyDataSetChanged()
        updateScreen2()
    }

    private fun updateScreen2(){
        if (MainActivity.doingListMain.isNullOrEmpty()){
            binding.txtNothingToShow2.visibility = View.VISIBLE
            binding.imgNothing2.visibility = View.VISIBLE
        }else{
            binding.txtNothingToShow2.visibility = View.GONE
            binding.imgNothing2.visibility = View.GONE
        }
    }

}