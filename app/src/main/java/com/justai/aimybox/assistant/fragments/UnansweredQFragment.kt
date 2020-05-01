package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.UnansweredQ
import com.justai.aimybox.assistant.adapters.UnAnsweredQAdapter

class UnansweredQFragment : Fragment() {

    var post_array = ArrayList<UnansweredQ>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_unanswered_q, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        post_array.add(UnansweredQ(getString(R.string.relationship_q2), "Richie", "Sk. 1 iliyopita", "Majibu: 0"))
        post_array.add(UnansweredQ(getString(R.string.family_planning_q3), "She girl", "Sk. 3 iliyopita", "Majibu: 0"))
        post_array.add(UnansweredQ(getString(R.string.hiv_and_sti_q1), "Football fan", "Sk. 3 iliyopita", "Majibu: 0"))
        post_array.add(UnansweredQ(getString(R.string.hiv_and_sti_q7), "Fukia Mashimo", "Sk. 5 iliyopita", "Majibu: 0"))
        post_array.add(UnansweredQ(getString(R.string.hiv_and_sti_q4), "Mondi Mwenyewe", "Sk. 7 iliyopita", "Majibu: 0"))
        post_array.add(UnansweredQ(getString(R.string.family_planning_q5), "Msaga Sumu", "Sk. 8 iliyopita", "Majibu: 0"))

        val unansweredQAdapter =
            UnAnsweredQAdapter(view.context, post_array)
        recyclerView.adapter = unansweredQAdapter

        return view
    }
}
