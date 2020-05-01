package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.justai.aimybox.assistant.AnsweredQ
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.YourQuestion
import com.justai.aimybox.assistant.adapters.AnsweredQAdapter
import com.justai.aimybox.assistant.adapters.YourQAdapter
import kotlinx.android.synthetic.main.fragment_qa_for_you.*

class QAForYouFragment : Fragment() {

    lateinit var qnCardView: MaterialCardView
    lateinit var ansCardView: MaterialCardView

    var yourQuestions_array = ArrayList<YourQuestion>()
    var post_array = ArrayList<AnsweredQ>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_qa_for_you, container, false)

        qnCardView = view.findViewById(R.id.qn)
        ansCardView = view.findViewById(R.id.ans)
        val ans_txt = view.findViewById<TextView>(R.id.ans_txt)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager

        yourQuestions_array.add(YourQuestion(getString(R.string.hiv_and_sti_q1), "", "Wewe", "Sk. 4 iliyopita", "Majibu: 0"))
        yourQuestions_array.add(YourQuestion(getString(R.string.hiv_and_sti_q3), getString(R.string.hiv_and_sti_ans3), "Wewe", "Sk. 4 zilizopita", "Majibu: 1"))

        var yourQAdapter =
            YourQAdapter(view.context, yourQuestions_array)
        recyclerView.adapter = yourQAdapter

        qnCardView.background = resources.getDrawable(R.drawable.material_card_bg)
        ansCardView.background = resources.getDrawable(R.drawable.white_material_card_bg)
        ans_txt.setTextColor(resources.getColor(R.color.black))

        qnCardView.setOnClickListener{
            qnCardView.background = resources.getDrawable(R.drawable.material_card_bg)
            ansCardView.background = resources.getDrawable(R.drawable.white_material_card_bg)
            qn_txt.setTextColor(resources.getColor(R.color.white))
            ans_txt.setTextColor(resources.getColor(R.color.black))
            yourQuestions_array = ArrayList()
            yourQuestions_array.add(YourQuestion(getString(R.string.hiv_and_sti_q1), "", "Wewe", "Sk. 4 iliyopita", "Majibu: 0"))
            yourQuestions_array.add(YourQuestion(getString(R.string.hiv_and_sti_q3), getString(R.string.hiv_and_sti_ans3), "Wewe", "Sk. 4 zilizopita", "Majibu: 1"))
            yourQAdapter =
                YourQAdapter(view.context, yourQuestions_array)
            recyclerView.adapter = yourQAdapter
        }

        ansCardView.setOnClickListener{
            qnCardView.background = resources.getDrawable(R.drawable.white_material_card_bg)
            ansCardView.background = resources.getDrawable(R.drawable.material_card_bg)
            qn_txt.setTextColor(resources.getColor(R.color.black))
            ans_txt.setTextColor(resources.getColor(R.color.white))
            post_array = ArrayList()
            post_array.add(
                AnsweredQ("Jibaba lao", "Sk. 1 iliyopita", getString(R.string.hiv_and_sti_q2), getString(R.string.hiv_and_sti_ans2), "Majibu: 1", "2", "0"))
            post_array.add(AnsweredQ("Princess Lysa", "Sk. 1 iliyopita", getString(R.string.relationship_q3), getString(R.string.relationship_ans3), "Majibu: 1", "4", "0"))
            post_array.add(AnsweredQ("Junior Guy", "Sk. 4 zilizopita", getString(R.string.family_planning_q2), getString(R.string.family_planning_ans2), "Majibu: 1", "2", "0"))
            post_array.add(AnsweredQ("Mtoa Konki", "Sk. 5 zilizopita", getString(R.string.hiv_and_sti_q5), getString(R.string.hiv_and_sti_ans5), "Majibu: 1", "7", "1"))
            val answeredQAdapter =
                AnsweredQAdapter(view.context, post_array, 2)
            recyclerView.adapter = answeredQAdapter
        }

        return view
    }
}
