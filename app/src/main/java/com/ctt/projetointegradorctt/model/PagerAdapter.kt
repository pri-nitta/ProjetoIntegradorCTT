package com.ctt.projetointegradorctt.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ctt.projetointegradorctt.DoingFragment
import com.ctt.projetointegradorctt.DoneFragment
import com.ctt.projetointegradorctt.ToDoFragment

class PagerAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ToDoFragment()
            1 -> DoingFragment()
            2 -> DoneFragment()
            else -> ToDoFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "To Do"
            1 -> "Doing"
            2 -> "Done"
            else -> super.getPageTitle(position)
        }
    }

}