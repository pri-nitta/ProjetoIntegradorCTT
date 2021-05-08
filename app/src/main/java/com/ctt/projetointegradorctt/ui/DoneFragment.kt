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
import com.ctt.projetointegradorctt.databinding.FragmentDoneBinding
import com.ctt.projetointegradorctt.model.DoneAdapter

class DoneFragment : androidx.fragment.app.Fragment() {
    private lateinit var binding: FragmentDoneBinding
    lateinit var doneAdapter: DoneAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_done,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doneAdapter = DoneAdapter(MainActivity.doneListaMain)
        binding.doneList.adapter = doneAdapter
        binding.doneList.layoutManager = LinearLayoutManager(requireContext())
        updateScreen3()
    }

    override fun onResume() {
        super.onResume()
        doneAdapter.notifyDataSetChanged()
        updateScreen3()
    }
    private fun updateScreen3() {
        if (MainActivity.doneListaMain.isNullOrEmpty()) {
            binding.txtNothingToShow3.visibility = View.VISIBLE
            binding.imgNothing3.visibility = View.VISIBLE
        } else {
            binding.txtNothingToShow3.visibility = View.GONE
            binding.imgNothing3.visibility = View.GONE
        }
    }

}