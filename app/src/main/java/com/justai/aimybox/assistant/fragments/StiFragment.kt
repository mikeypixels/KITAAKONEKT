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
class StiFragment : Fragment() {

    internal var whatIsHIVLayout: ExpandableLinearLayout? = null
    internal var VVUHuambukizwavipiLayout: ExpandableLinearLayout? = null
    internal var NiNiniKinakuwekaHatariniLayout: ExpandableLinearLayout? = null

    private fun initmyLayout() {
        whatIsHIVLayout?.initLayout()
        VVUHuambukizwavipiLayout?.initLayout()
        NiNiniKinakuwekaHatariniLayout?.initLayout()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_sti, container, false)

        val whatIsHIVText = view.findViewById<TextView>(R.id.whatIsHIVText)
        val VVUHuambukizwavipiText = view.findViewById<TextView>(R.id.VVUHuambukizwavipiText)
        val NiNiniKinakuwekaHatariniText = view.findViewById<TextView>(R.id.NiNiniKinakuwekaHatariniText)

        val btnWIH = view.findViewById<MaterialCardView>(R.id.btnWIH)
        val btnVHV = view.findViewById<MaterialCardView>(R.id.btnVHV)
        val btnNNKH = view.findViewById<MaterialCardView>(R.id.btnNNKH)

        whatIsHIVLayout = view.findViewById(R.id.whatIsHIVLayout)
        btnWIH.setOnClickListener {
            onClick(btnWIH)
        }
        VVUHuambukizwavipiLayout = view.findViewById(R.id.VVUHuambukizwavipiLayout)
        btnVHV.setOnClickListener {
            onClick(btnVHV)
        }
        NiNiniKinakuwekaHatariniLayout = view.findViewById(R.id.NiNiniKinakuwekaHatariniLayout)
        btnNNKH.setOnClickListener {
            onClick(btnNNKH)
        }

        whatIsHIVText.text = resources.getString(R.string.what_is_hiv)
        VVUHuambukizwavipiText.text = resources.getString(R.string.how_is_hiv_transmitted)
        NiNiniKinakuwekaHatariniText.text = resources.getString(R.string.what_puts_you_at_risk)

        return view
    }

    fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btnWIH -> {
                    whatIsHIVLayout?.toggle()
                    VVUHuambukizwavipiLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                }

                R.id.btnVHV -> {
                    VVUHuambukizwavipiLayout?.toggle()
                    whatIsHIVLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                }

                R.id.btnNNKH -> {
                    NiNiniKinakuwekaHatariniLayout?.toggle()
                    whatIsHIVLayout?.collapse()
                    VVUHuambukizwavipiLayout?.collapse()
                }

                else -> {

                }
            }
        }
        initmyLayout()
    }

}
