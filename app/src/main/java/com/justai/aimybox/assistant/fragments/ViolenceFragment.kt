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
import kotlinx.android.synthetic.main.fragment_violence.*

/**
 * A simple [Fragment] subclass.
 */
class ViolenceFragment : Fragment() {

    internal var whatIsVuruguLayout: ExpandableLinearLayout? = null
    internal var UnyanyasajiWaKijinsiaLayout: ExpandableLinearLayout? = null
    internal var JeWajuaLayout: ExpandableLinearLayout? = null
    internal var UbakajiLayout: ExpandableLinearLayout? = null
    internal var JinsiYaKujikingaLayout: ExpandableLinearLayout? = null
    internal var JinsiYaKukabilianaLayout: ExpandableLinearLayout? = null
    internal var UhalifuWaNgonoLayout: ExpandableLinearLayout? = null

    private fun initmyLayout() {
        whatIsVuruguLayout?.initLayout()
        UnyanyasajiWaKijinsiaLayout?.initLayout()
        JeWajuaLayout?.initLayout()
        UbakajiLayout?.initLayout()
        JinsiYaKujikingaLayout?.initLayout()
        JinsiYaKukabilianaLayout?.initLayout()
        UhalifuWaNgonoLayout?.initLayout()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_violence, container, false)

        val whatIsVuruguText = view.findViewById<TextView>(R.id.whatIsVuruguText)
        val unyanyasajiWaKijinsiaText = view.findViewById<TextView>(R.id.UnyanyasajiWaKijinsiaText)
        val jeWajuaText = view.findViewById<TextView>(R.id.JeWajuaText)
        val ubakajiText = view.findViewById<TextView>(R.id.UbakajiText)
        val jinsiYaKujikingaText = view.findViewById<TextView>(R.id.JinsiYaKujikingaText)
        val jinsiYaKukabilianaText = view.findViewById<TextView>(R.id.jinsiYaKukabilianaText)
        val uhalifuWaNgonoText = view.findViewById<TextView>(R.id.UhalifuWaNgonoText)

        val btnWIV = view.findViewById<MaterialCardView>(R.id.btnWIV)
        val btnUWK = view.findViewById<MaterialCardView>(R.id.btnUWK)
        val btnUbakaji = view.findViewById<MaterialCardView>(R.id.btnUbakaji)
        val btnJYKNUWK = view.findViewById<MaterialCardView>(R.id.btnJYKNUWK)
        val btnJKNUWK = view.findViewById<MaterialCardView>(R.id.btnJKNUWK)
        val btnUWNM = view.findViewById<MaterialCardView>(R.id.btnUWNM)
        val btnJW = view.findViewById<MaterialCardView>(R.id.btnJW)

        whatIsVuruguLayout = view.findViewById(R.id.whatIsVuruguLayout)
        btnWIV.setOnClickListener {
            onClick(btnWIV)
        }
        UnyanyasajiWaKijinsiaLayout = view.findViewById(R.id.UnyanyasajiWaKijinsiaLayout)
        btnUWK.setOnClickListener {
            onClick(btnUWK)
        }
        JeWajuaLayout = view.findViewById(R.id.JeWajuaLayout)
        btnJW.setOnClickListener {
            onClick(btnJW)
        }
        UbakajiLayout = view.findViewById(R.id.UbakajiLayout)
        btnUbakaji.setOnClickListener {
            onClick(btnUbakaji)
        }
        JinsiYaKujikingaLayout = view.findViewById(R.id.JinsiYaKujikingaLayout)
        btnJYKNUWK.setOnClickListener {
            onClick(btnJYKNUWK)
        }
        JinsiYaKukabilianaLayout = view.findViewById(R.id.jinsiYaKukabilianaLayout)
        btnJKNUWK.setOnClickListener {
            onClick(btnJKNUWK)
        }
        UhalifuWaNgonoLayout = view.findViewById(R.id.UhalifuWaNgonoLayout)
        btnUWNM.setOnClickListener {
            onClick(btnUWNM)
        }

        whatIsVuruguText.text = resources.getString(R.string.what_is_violence)
        unyanyasajiWaKijinsiaText.text = resources.getString(R.string.sexual_assaults)
        jeWajuaText.text = resources.getString(R.string.facts)
        ubakajiText.text = resources.getString(R.string.rape)
        jinsiYaKujikingaText.text = resources.getString(R.string.how_to_protect_yourself_from_sexual_assaults)
        jinsiYaKukabilianaText.text = resources.getString(R.string.how_to_cope_with_sexual_assaults)
        uhalifuWaNgonoText.text = resources.getString(R.string.cyber_sexual_crimes)

        return view
    }

    fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btnWIV -> {
                    whatIsVuruguLayout?.toggle()
                    UnyanyasajiWaKijinsiaLayout?.collapse()
                    JeWajuaLayout?.collapse()
                    UbakajiLayout?.collapse()
                    JinsiYaKujikingaLayout?.collapse()
                    JinsiYaKukabilianaLayout?.collapse()
                    UhalifuWaNgonoLayout?.collapse()
                }

                R.id.btnUWK -> {
                    UnyanyasajiWaKijinsiaLayout?.toggle()
                    whatIsVuruguLayout?.collapse()
                    JeWajuaLayout?.collapse()
                    UbakajiLayout?.collapse()
                    JinsiYaKujikingaLayout?.collapse()
                    JinsiYaKukabilianaLayout?.collapse()
                    UhalifuWaNgonoLayout?.collapse()
                }

                R.id.btnJW -> {
                    JeWajuaLayout?.toggle()
                    whatIsVuruguLayout?.collapse()
                    UnyanyasajiWaKijinsiaLayout?.collapse()
                    UbakajiLayout?.collapse()
                    JinsiYaKujikingaLayout?.collapse()
                    JinsiYaKukabilianaLayout?.collapse()
                    UhalifuWaNgonoLayout?.collapse()
                }

                R.id.btnUbakaji -> {
                    UbakajiLayout?.toggle()
                    JeWajuaLayout?.collapse()
                    whatIsVuruguLayout?.collapse()
                    UnyanyasajiWaKijinsiaLayout?.collapse()
                    JinsiYaKujikingaLayout?.collapse()
                    UhalifuWaNgonoLayout?.collapse()
                }

                R.id.btnJYKNUWK -> {
                    JinsiYaKujikingaLayout?.toggle()
                    UbakajiLayout?.collapse()
                    JeWajuaLayout?.collapse()
                    whatIsVuruguLayout?.collapse()
                    UnyanyasajiWaKijinsiaLayout?.collapse()
                    JinsiYaKukabilianaLayout?.collapse()
                    UhalifuWaNgonoLayout?.collapse()
                }

                R.id.btnJKNUWK -> {
                    JinsiYaKukabilianaLayout?.toggle()
                    UbakajiLayout?.collapse()
                    JeWajuaLayout?.collapse()
                    whatIsVuruguLayout?.collapse()
                    UnyanyasajiWaKijinsiaLayout?.collapse()
                    JinsiYaKujikingaLayout?.collapse()
                    UhalifuWaNgonoLayout?.collapse()
                }

                R.id.btnUWNM -> {
                    UhalifuWaNgonoLayout?.toggle()
                    UbakajiLayout?.collapse()
                    JeWajuaLayout?.collapse()
                    whatIsVuruguLayout?.collapse()
                    UnyanyasajiWaKijinsiaLayout?.collapse()
                    JinsiYaKujikingaLayout?.collapse()
                }

                else -> {

                }
            }
        }
        initmyLayout()
    }

}
