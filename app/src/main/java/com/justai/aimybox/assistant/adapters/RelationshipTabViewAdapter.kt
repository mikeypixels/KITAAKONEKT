package com.justai.aimybox.assistant.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.justai.aimybox.assistant.fragments.SubRelationshipsFragment
import com.justai.aimybox.assistant.fragments.ViolenceFragment

class RelationshipTabViewAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return SubRelationshipsFragment()
            1 -> return ViolenceFragment()
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return 2
    }

    //To make only images tabs this method should return null
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "MAHUSIANO"
            1 -> "VURUGU"
            else -> null
        }
    }
}