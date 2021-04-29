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

    lateinit var doneAdapter: DoneAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDoneBinding>(
            inflater,
            R.layout.fragment_done,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvDone = view.findViewById<RecyclerView>(R.id.doneList)
        doneAdapter = DoneAdapter(MainActivity.doneListaMain)
        rvDone.adapter = doneAdapter
        rvDone.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        doneAdapter.notifyDataSetChanged()

        val textEmpty = requireView().findViewById<TextView>(R.id.txtNothingToShow3)
        val imgNothing = requireView().findViewById<ImageView>(R.id.imgNothing3)

        if (MainActivity.doneListaMain.isNullOrEmpty()) {
            textEmpty.visibility = View.VISIBLE
            imgNothing.visibility = View.VISIBLE
        } else {
            textEmpty.visibility = View.GONE
            imgNothing.visibility = View.GONE
        }
    }

}