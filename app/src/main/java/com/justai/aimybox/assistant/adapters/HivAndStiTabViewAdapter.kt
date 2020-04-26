package com.justai.aimybox.assistant.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.justai.aimybox.assistant.fragments.HivFragment
import com.justai.aimybox.assistant.fragments.StiFragment

class HivAndStiTabViewAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return HivFragment()
            1 -> return StiFragment()
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return 2
    }

    //To make only images tabs this method should return null
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "HIV"
            1 -> "STIs"
            else -> null
        }
    }
}