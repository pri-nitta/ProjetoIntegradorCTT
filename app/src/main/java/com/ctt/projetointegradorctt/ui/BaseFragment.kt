package com.ctt.projetointegradorctt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ctt.projetointegradorctt.R
import com.ctt.projetointegradorctt.databinding.ActivityMainBinding
import com.ctt.projetointegradorctt.databinding.FragmentBaseBinding
import com.ctt.projetointegradorctt.model.PagerAdapter
import kotlinx.android.synthetic.main.item_to_do.*

class BaseFragment : Fragment() {

    private lateinit var binding: FragmentBaseBinding
    private val bsFragmentViewTask = ViewTaskBSheetFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val edtSearchTask = binding.edtSearchTask3
        viewPager.adapter = PagerAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        binding.btnSearch.setOnClickListener {
            val typedTask = edtSearchTask.text.toString()
            if (typedTask == txtToDoTitle.text) {
                bsFragmentViewTask.show(childFragmentManager, "View Task BS")
            } else {
                edtSearchTask.error = (getString(R.string.error_find_task))
            }
        }
    }
}