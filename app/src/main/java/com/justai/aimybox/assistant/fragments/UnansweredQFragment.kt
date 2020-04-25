package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.adapters.UnAnsweredQAdapter

class UnansweredQFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_unanswered_q, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        val unansweredQAdapter =
            UnAnsweredQAdapter(view.context)
        recyclerView.adapter = unansweredQAdapter

        return view
    }
}
