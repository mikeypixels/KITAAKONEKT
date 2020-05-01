package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justai.aimybox.assistant.AnsweredQ
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.adapters.AnsweredQAdapter

/**
 * A simple [Fragment] subclass.
 */
class AnsweredQFragment : Fragment() {

    val post_array = ArrayList<AnsweredQ>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_answered_q, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        post_array.add(AnsweredQ("Barbie princess", "dkk. 56 zilizopita", getString(R.string.relationship_q1), getString(R.string.relationship_ans1), "Majibu: 1", "3", "0"))
        post_array.add(AnsweredQ("Jibaba lao", "Sk. 1 iliyopita", getString(R.string.hiv_and_sti_q2), getString(R.string.hiv_and_sti_ans2), "Majibu: 1", "2", "0"))
        post_array.add(AnsweredQ("Gracoius", "Sk. 1 iliyopita", getString(R.string.hiv_and_sti_q6), getString(R.string.hiv_and_sti_ans6), "Majibu: 1", "6", "1"))
        post_array.add(AnsweredQ("Princess Lysa", "Sk. 1 iliyopita", getString(R.string.relationship_q3), getString(R.string.relationship_ans3), "Majibu: 1", "4", "0"))
        post_array.add(AnsweredQ("Anonymous", "Sk. 2 zilizopita", getString(R.string.family_planning_q1), getString(R.string.family_planning_ans1), "Majibu: 1", "3", "0"))
        post_array.add(AnsweredQ("Wendylicious", "Sk. 3 zilizopita", getString(R.string.family_planning_q4), getString(R.string.family_planning_ans4), "Majibu: 1", "1", "1"))
        post_array.add(AnsweredQ("Football fan", "Sk. 4 zilizopita", getString(R.string.hiv_and_sti_q3), getString(R.string.hiv_and_sti_ans3), "Majibu: 1", "1", "0"))
        post_array.add(AnsweredQ("Junior Guy", "Sk. 4 zilizopita", getString(R.string.family_planning_q2), getString(R.string.family_planning_ans2), "Majibu: 1", "2", "0"))
        post_array.add(AnsweredQ("Mtoa Konki", "Sk. 5 zilizopita", getString(R.string.hiv_and_sti_q5), getString(R.string.hiv_and_sti_ans5), "Majibu: 1", "7", "1"))

        val answeredQAdapter =
            AnsweredQAdapter(view.context, post_array, 1)
        recyclerView.adapter = answeredQAdapter

        return view
    }

}
