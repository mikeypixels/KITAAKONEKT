package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import com.google.android.material.card.MaterialCardView

import com.justai.aimybox.assistant.R

/**
 * A simple [Fragment] subclass.
 */
class SubRelationshipsFragment : Fragment() {

    internal var expmahusianoLayout: ExpandableLinearLayout? = null
    internal var expnjiaZaMahusianoLayout: ExpandableLinearLayout? = null
    internal var expmahusianoWazaziWazeeLayout: ExpandableLinearLayout? = null
    internal var expmahusianoMarafikiLayout: ExpandableLinearLayout? = null
    internal var expmahusianoKimapenziLayout: ExpandableLinearLayout? = null
    internal var expisharaUhusianoAfyaMbayaLayout: ExpandableLinearLayout? = null

    private fun initmyLayout() {
        expmahusianoLayout?.initLayout()
        expnjiaZaMahusianoLayout?.initLayout()
        expmahusianoWazaziWazeeLayout?.initLayout()
        expmahusianoMarafikiLayout?.initLayout()
        expmahusianoKimapenziLayout?.initLayout()
        expisharaUhusianoAfyaMbayaLayout?.initLayout()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_sub_relationships, container, false)

        val mahusianoText = view.findViewById<TextView>(R.id.mahusianoText)
        val njiaZaMahusianoText = view.findViewById<TextView>(R.id.njiaZaMahusianoText)
        val mahusianoWazaziWazeeText = view.findViewById<TextView>(R.id.mahusianoWazaziWazeeText)
        val mahusianoMarafikiText = view.findViewById<TextView>(R.id.mahusianoMarafikiText)
        val mahusianoKimapenziText = view.findViewById<TextView>(R.id.mahusianoKimapenziText)
        val isharaUhusianoAfyaMbayaText = view.findViewById<TextView>(R.id.isharaUhusianoAfyaMbayaText)

        val btnM = view.findViewById<MaterialCardView>(R.id.btnM)
        val btnNBZM = view.findViewById<MaterialCardView>(R.id.btnNBZM)
        val btnMWW = view.findViewById<MaterialCardView>(R.id.btnMWW)
        val btnMNM = view.findViewById<MaterialCardView>(R.id.btnMNM)
        val btnMYK = view.findViewById<MaterialCardView>(R.id.btnMYK)
        val btnIZUWANM = view.findViewById<MaterialCardView>(R.id.btnIZUWANM)

        expmahusianoLayout = view.findViewById(R.id.mahusianoLayout)
        btnM.setOnClickListener {
            onClick(btnM)
        }
        expnjiaZaMahusianoLayout = view.findViewById(R.id.njiaZaMahusianoLayout)
        btnNBZM.setOnClickListener {
            onClick(btnNBZM)
        }
        expmahusianoWazaziWazeeLayout = view.findViewById(R.id.mahusianoWazaziWazeeLayout)
        btnMWW.setOnClickListener {
            onClick(btnMWW)
        }
        expmahusianoMarafikiLayout = view.findViewById(R.id.mahusianoMarafikiLayout)
        btnMNM.setOnClickListener {
            onClick(btnMNM)
        }
        expmahusianoKimapenziLayout = view.findViewById(R.id.mahusianoKimapenziLayout)
        btnMYK.setOnClickListener {
            onClick(btnMYK)
        }
        expisharaUhusianoAfyaMbayaLayout = view.findViewById(R.id.isharaUhusianoAfyaMbayaLayout)
        btnIZUWANM.setOnClickListener {
            onClick(btnIZUWANM)
        }

        mahusianoText.text = resources.getString(R.string.relationships)
        njiaZaMahusianoText.text = resources.getString(R.string.key_to_healthy_relationships)
        mahusianoWazaziWazeeText.text = resources.getString(R.string.relationships_with_parents_and_elders)
        mahusianoMarafikiText.text = resources.getString(R.string.relationships_with_friends)
        mahusianoKimapenziText.text = resources.getString(R.string.relationship_with_special_someone)
        isharaUhusianoAfyaMbayaText.text = resources.getString(R.string.signs_of_healthy_and_unhealthy_relationships)

        return view
    }

    fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btnM -> {
                    expmahusianoLayout?.toggle()
                    expnjiaZaMahusianoLayout?.collapse()
                    expmahusianoWazaziWazeeLayout?.collapse()
                    expmahusianoMarafikiLayout?.collapse()
                    expmahusianoKimapenziLayout?.collapse()
                    expisharaUhusianoAfyaMbayaLayout?.collapse()
                }

                R.id.btnNBZM -> {
                    expnjiaZaMahusianoLayout?.toggle()
                    expmahusianoLayout?.collapse()
                    expmahusianoWazaziWazeeLayout?.collapse()
                    expmahusianoMarafikiLayout?.collapse()
                    expmahusianoKimapenziLayout?.collapse()
                    expisharaUhusianoAfyaMbayaLayout?.collapse()
                }

                R.id.btnMWW -> {
                    expmahusianoWazaziWazeeLayout?.toggle()
                    expmahusianoLayout?.collapse()
                    expnjiaZaMahusianoLayout?.collapse()
                    expmahusianoMarafikiLayout?.collapse()
                    expmahusianoKimapenziLayout?.collapse()
                    expisharaUhusianoAfyaMbayaLayout?.collapse()
                }

                R.id.btnMNM -> {
                    expmahusianoMarafikiLayout?.toggle()
                    expmahusianoWazaziWazeeLayout?.collapse()
                    expmahusianoLayout?.collapse()
                    expnjiaZaMahusianoLayout?.collapse()
                    expmahusianoKimapenziLayout?.collapse()
                    expisharaUhusianoAfyaMbayaLayout?.collapse()
                }

                R.id.btnMYK -> {
                    expmahusianoKimapenziLayout?.toggle()
                    expmahusianoMarafikiLayout?.collapse()
                    expmahusianoWazaziWazeeLayout?.collapse()
                    expmahusianoLayout?.collapse()
                    expnjiaZaMahusianoLayout?.collapse()
                    expisharaUhusianoAfyaMbayaLayout?.collapse()
                }

                R.id.btnIZUWANM -> {
                    expisharaUhusianoAfyaMbayaLayout?.toggle()
                    expmahusianoMarafikiLayout?.collapse()
                    expmahusianoWazaziWazeeLayout?.collapse()
                    expmahusianoLayout?.collapse()
                    expnjiaZaMahusianoLayout?.collapse()
                    expmahusianoKimapenziLayout?.collapse()
                }

                else -> {

                }
            }
        }
        initmyLayout()
    }

}
