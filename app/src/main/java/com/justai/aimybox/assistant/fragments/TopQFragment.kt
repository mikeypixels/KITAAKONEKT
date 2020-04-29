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
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.adapters.topQAdapter
import com.justai.aimybox.assistant.utils.ExitWithAnimation
import com.justai.aimybox.assistant.utils.startCircularReveal

/**
 * A simple [Fragment] subclass.
 */
class TopQFragment : Fragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): TopQFragment = TopQFragment()
            .apply {
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
        val view: View = inflater.inflate(R.layout.fragment_top_q, container, false)

        val mahusiano_card = view.findViewById<MaterialCardView>(R.id.mahusiano_card)
        val family_plan_card = view.findViewById<MaterialCardView>(R.id.family_plan_card)
        val hiv_sti_card = view.findViewById<MaterialCardView>(R.id.hiv_sti_card)

        val mahusiano_txt = view.findViewById<TextView>(R.id.mahusiano_txt)
        val family_plan_txt = view.findViewById<TextView>(R.id.family_plan_txt)
        val hiv_sti_txt = view.findViewById<TextView>(R.id.hiv_sti_txt)

        val relationship_questions = arrayOf(context?.getString(R.string.relationship_q1), context?.getString(R.string.relationship_q2), context?.getString(R.string.relationship_q3))
        val relationship_answers = arrayOf(context?.getString(R.string.relationship_ans1), context?.getString(R.string.relationship_ans2), context?.getString(R.string.relationship_ans3))
        val family_plan_questions = arrayOf(context?.getString(R.string.family_planning_q1), context?.getString(R.string.family_planning_q2), context?.getString(R.string.family_planning_q3), context?.getString(R.string.family_planning_q4), context?.getString(R.string.family_planning_q5))
        val family_plan_answers = arrayOf(context?.getString(R.string.family_planning_ans1), context?.getString(R.string.family_planning_ans2), context?.getString(R.string.family_planning_ans3), context?.getString(R.string.family_planning_ans4), context?.getString(R.string.family_planning_ans5))
        val hiv_sti_questions = arrayOf(context?.getString(R.string.hiv_and_sti_q1), context?.getString(R.string.hiv_and_sti_q2), context?.getString(R.string.hiv_and_sti_q3), context?.getString(R.string.hiv_and_sti_q4), context?.getString(R.string.hiv_and_sti_q5), context?.getString(R.string.hiv_and_sti_q6), context?.getString(R.string.hiv_and_sti_q7))
        val hiv_sti_answers = arrayOf(context?.getString(R.string.hiv_and_sti_ans1), context?.getString(R.string.hiv_and_sti_ans2), context?.getString(R.string.hiv_and_sti_ans3), context?.getString(R.string.hiv_and_sti_ans4), context?.getString(R.string.hiv_and_sti_ans5), context?.getString(R.string.hiv_and_sti_ans6), context?.getString(R.string.hiv_and_sti_ans7))

        val recyclerView: RecyclerView = view.findViewById(R.id.questions_recyclerView)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false)
        recyclerView.layoutManager = linearLayoutManager

        val adapter = context?.let { topQAdapter(it, relationship_questions, relationship_answers) }
        recyclerView.adapter = adapter

        mahusiano_card.background = resources.getDrawable(R.drawable.top_q_choice_bg)
        family_plan_card.background = resources.getDrawable(R.drawable.white_material_card_bg)
        hiv_sti_card.background = resources.getDrawable(R.drawable.white_material_card_bg)
        mahusiano_txt.setTextColor(resources.getColor(R.color.white))


        mahusiano_card.setOnClickListener {
            mahusiano_card.background = resources.getDrawable(R.drawable.top_q_choice_bg)
            family_plan_card.background = resources.getDrawable(R.drawable.white_material_card_bg)
            hiv_sti_card.background = resources.getDrawable(R.drawable.white_material_card_bg)
            mahusiano_txt.setTextColor(resources.getColor(R.color.white))
            family_plan_txt.setTextColor(resources.getColor(R.color.deeppink))
            hiv_sti_txt.setTextColor(resources.getColor(R.color.deeppink))

            val adapterRelationship = context?.let { topQAdapter(it, relationship_questions, relationship_answers) }
            recyclerView.adapter = adapterRelationship
        }

        family_plan_card.setOnClickListener {
            mahusiano_card.background = resources.getDrawable(R.drawable.white_material_card_bg)
            family_plan_card.background = resources.getDrawable(R.drawable.top_q_choice_bg)
            hiv_sti_card.background = resources.getDrawable(R.drawable.white_material_card_bg)
            mahusiano_txt.setTextColor(resources.getColor(R.color.deeppink))
            family_plan_txt.setTextColor(resources.getColor(R.color.white))
            hiv_sti_txt.setTextColor(resources.getColor(R.color.deeppink))

            val adapterFamilyPlan = context?.let { topQAdapter(it, family_plan_questions, family_plan_answers) }
            recyclerView.adapter = adapterFamilyPlan
        }

        hiv_sti_card.setOnClickListener {
            mahusiano_card.background = resources.getDrawable(R.drawable.white_material_card_bg)
            family_plan_card.background = resources.getDrawable(R.drawable.white_material_card_bg)
            hiv_sti_card.background = resources.getDrawable(R.drawable.top_q_choice_bg)
            mahusiano_txt.setTextColor(resources.getColor(R.color.deeppink))
            family_plan_txt.setTextColor(resources.getColor(R.color.deeppink))
            hiv_sti_txt.setTextColor(resources.getColor(R.color.white))

            val adapterHivSti = context?.let { topQAdapter(it, hiv_sti_questions, hiv_sti_answers) }
            recyclerView.adapter = adapterHivSti
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(false, posX as Int, posY as Int)
    }

}
