package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.adapters.HelpCentersAdapter
import com.justai.aimybox.assistant.utils.ExitWithAnimation
import com.justai.aimybox.assistant.utils.startCircularReveal

class HelpCentersFragment : Fragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): HelpCentersFragment = HelpCentersFragment().apply {
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
        val view: View = inflater.inflate(R.layout.fragment_help_centers, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.help_centers_recyclerView)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager

        val helpCentersAdapter = context?.let { HelpCentersAdapter(it) }
        recyclerView.adapter = helpCentersAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(false, posX as Int, posY as Int)
    }
}
