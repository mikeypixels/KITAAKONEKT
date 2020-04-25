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
import com.justai.aimybox.assistant.adapters.YourQAdapter
import kotlinx.android.synthetic.main.fragment_qa_for_you.*

class QAForYouFragment : Fragment() {

    lateinit var qnCardView: MaterialCardView
    lateinit var ansCardView: MaterialCardView

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

        val yourQAdapter =
            YourQAdapter(view.context)
        recyclerView.adapter = yourQAdapter

        qnCardView.background = resources.getDrawable(R.drawable.material_card_bg)
        ansCardView.background = resources.getDrawable(R.drawable.white_material_card_bg)
        ans_txt.setTextColor(resources.getColor(R.color.black))

        qnCardView.setOnClickListener{
            qnCardView.background = resources.getDrawable(R.drawable.material_card_bg)
            ansCardView.background = resources.getDrawable(R.drawable.white_material_card_bg)
            qn_txt.setTextColor(resources.getColor(R.color.white))
            ans_txt.setTextColor(resources.getColor(R.color.black))
        }

        ansCardView.setOnClickListener{
            qnCardView.background = resources.getDrawable(R.drawable.white_material_card_bg)
            ansCardView.background = resources.getDrawable(R.drawable.material_card_bg)
            qn_txt.setTextColor(resources.getColor(R.color.black))
            ans_txt.setTextColor(resources.getColor(R.color.white))
        }

        return view
    }
}
