package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.adapters.FactsAdapter
import com.justai.aimybox.assistant.utils.ExitWithAnimation
import com.justai.aimybox.assistant.utils.startCircularReveal

/**
 * A simple [Fragment] subclass.
 */
class FactsFragment : Fragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): FactsFragment = FactsFragment().apply {
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
        val view: View = inflater.inflate(R.layout.fragment_facts, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.fact_recyclerView)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = linearLayoutManager

        val factsAdapter = context?.let { FactsAdapter(it) }
        recyclerView.adapter = factsAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(false, posX as Int, posY as Int)
    }

}
