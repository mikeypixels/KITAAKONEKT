package com.justai.aimybox.assistant.fragments

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.TransitionInflater
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.adapters.RelationshipTabViewAdapter
import com.justai.aimybox.assistant.utils.ExitWithAnimation
import com.justai.aimybox.assistant.utils.startCircularReveal

/**
 * A simple [Fragment] subclass.
 */
class RelationshipsFragment : Fragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): RelationshipsFragment = RelationshipsFragment().apply {
            if (exit != null && exit.size == 2) {
                posX = exit[0]
                posY = exit[1]

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_relationships, container, false)

        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        val myTabViewAdapter = RelationshipTabViewAdapter((context as AppCompatActivity).supportFragmentManager)
        viewPager.adapter = myTabViewAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition = TransitionInflater
                .from(context).inflateTransition(
                    android.R.transition.move // you can change this
                )
        }
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(false, posX as Int, posY as Int)
    }

}
