package com.justai.aimybox.assistant.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.justai.aimybox.assistant.fragments.AnsweredQFragment
import com.justai.aimybox.assistant.fragments.QAForYouFragment
import com.justai.aimybox.assistant.fragments.UnansweredQFragment

class ForumTabViewAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return AnsweredQFragment()
            1 -> return UnansweredQFragment()
            2 -> return QAForYouFragment()
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return 3
    }

    //To make only images tabs this method should return null
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Yaliyojibiwa"
            1 -> "Yasiyojibiwa"
            2 -> "Kwa ajili yako"
            else -> null
        }
    }


}