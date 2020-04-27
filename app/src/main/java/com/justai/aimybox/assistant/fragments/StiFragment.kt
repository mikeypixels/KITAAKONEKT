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

    internal var maambukiziYaZinaaLayout: ExpandableLinearLayout? = null
    internal var ainaZakeNiZipiLayout: ExpandableLinearLayout? = null
    internal var mawazoPotofuLayout: ExpandableLinearLayout? = null

    private fun initmyLayout() {
        maambukiziYaZinaaLayout?.initLayout()
        ainaZakeNiZipiLayout?.initLayout()
        mawazoPotofuLayout?.initLayout()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_sti, container, false)

        val maambukiziYaZinaaText = view.findViewById<TextView>(R.id.maambukiziYaZinaaText)
        val ainaZakeNiZipiText = view.findViewById<TextView>(R.id.ainaZakeNiZipiText)
        val mawazoPotofuText = view.findViewById<TextView>(R.id.mawazoPotofuText)

        val btnMYZ = view.findViewById<MaterialCardView>(R.id.btnMYZ)
        val btnAZNZ = view.findViewById<MaterialCardView>(R.id.btnAZNZ)
        val btnMPKMYZ = view.findViewById<MaterialCardView>(R.id.btnMPKMYZ)

        maambukiziYaZinaaLayout = view.findViewById(R.id.maambukiziYaZinaaLayout)
        btnMYZ.setOnClickListener {
            onClick(btnMYZ)
        }
        ainaZakeNiZipiLayout = view.findViewById(R.id.ainaZakeNiZipiLayout)
        btnAZNZ.setOnClickListener {
            onClick(btnAZNZ)
        }
        mawazoPotofuLayout = view.findViewById(R.id.mawazoPotofuLayout)
        btnMPKMYZ.setOnClickListener {
            onClick(btnMPKMYZ)
        }

        maambukiziYaZinaaText.text = resources.getString(R.string.what_is_sti)
        ainaZakeNiZipiText.text = resources.getString(R.string.what_are_its_types)
        mawazoPotofuText.text = resources.getString(R.string.myths_about_stis)

        return view
    }

    fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btnMYZ -> {
                    maambukiziYaZinaaLayout?.toggle()
                    ainaZakeNiZipiLayout?.collapse()
                    mawazoPotofuLayout?.collapse()
                }

                R.id.btnAZNZ -> {
                    ainaZakeNiZipiLayout?.toggle()
                    maambukiziYaZinaaLayout?.collapse()
                    mawazoPotofuLayout?.collapse()
                }

                R.id.btnMPKMYZ -> {
                    mawazoPotofuLayout?.toggle()
                    maambukiziYaZinaaLayout?.collapse()
                    ainaZakeNiZipiLayout?.collapse()
                }

                else -> {

                }
            }
        }
        initmyLayout()
    }

}
