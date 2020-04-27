package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import com.google.android.material.card.MaterialCardView

import com.justai.aimybox.assistant.R

/**
 * A simple [Fragment] subclass.
 */
class HivFragment : Fragment() {

    internal var whatIsHIVLayout: ExpandableLinearLayout? = null
    internal var VVUHuambukizwavipiLayout: ExpandableLinearLayout? = null
    internal var NiNiniKinakuwekaHatariniLayout: ExpandableLinearLayout? = null
    internal var NINiniDaliliZaMaambukiziLayout: ExpandableLinearLayout? = null
    internal var JinsiGaniVVUHushambuliaLayout: ExpandableLinearLayout? = null
    internal var VVUInawezajeKuzuiwaLayout: ExpandableLinearLayout? = null
    internal var KuishiNaVVULayout: ExpandableLinearLayout? = null
    internal var VVUInawezaKutibiwaLayout: ExpandableLinearLayout? = null
    internal var MawazoPotofuLayout: ExpandableLinearLayout? = null

    private fun initmyLayout() {
        whatIsHIVLayout?.initLayout()
        VVUHuambukizwavipiLayout?.initLayout()
        NiNiniKinakuwekaHatariniLayout?.initLayout()
        NINiniDaliliZaMaambukiziLayout?.initLayout()
        JinsiGaniVVUHushambuliaLayout?.initLayout()
        VVUInawezajeKuzuiwaLayout?.initLayout()
        KuishiNaVVULayout?.initLayout()
        VVUInawezaKutibiwaLayout?.initLayout()
        MawazoPotofuLayout?.initLayout()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_hiv, container, false)

        val whatIsHIVText = view.findViewById<TextView>(R.id.whatIsHIVText)
        val VVUHuambukizwavipiText = view.findViewById<TextView>(R.id.VVUHuambukizwavipiText)
        val NiNiniKinakuwekaHatariniText = view.findViewById<TextView>(R.id.NiNiniKinakuwekaHatariniText)
        val NiNiniDaliliZaMaambukiziText = view.findViewById<TextView>(R.id.NINiniDaliliZaMaambukiziText)
        val JinsiGaniVVUHushambuliaText = view.findViewById<TextView>(R.id.JinsiGaniVVUHushambuliaText)
        val VVUInawezajeKuzuiwaText = view.findViewById<TextView>(R.id.VVUInawezajeKuzuiwaText)
        val KuishiNaVVUText = view.findViewById<TextView>(R.id.KuishiNaVVUText)
        val VVUInawezaKutibiwaText = view.findViewById<TextView>(R.id.VVUInawezaKutibiwaText)
        val MawazoPotofuText = view.findViewById<TextView>(R.id.MawazoPotofuText)

        val btnWIH = view.findViewById<MaterialCardView>(R.id.btnWIH)
        val btnVHV = view.findViewById<MaterialCardView>(R.id.btnVHV)
        val btnNNKH = view.findViewById<MaterialCardView>(R.id.btnNNKH)
        val btnNNDZMYV = view.findViewById<MaterialCardView>(R.id.btnNNDZMYV)
        val btnJGVHK = view.findViewById<MaterialCardView>(R.id.btnJGVHK)
        val btnVIZ = view.findViewById<MaterialCardView>(R.id.btnVIZ)
        val btnKNV = view.findViewById<MaterialCardView>(R.id.btnKNV)
        val btnVIK = view.findViewById<MaterialCardView>(R.id.btnVIK)
        val btnMPKV = view.findViewById<MaterialCardView>(R.id.btnMPKV)

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
        NINiniDaliliZaMaambukiziLayout = view.findViewById(R.id.NINiniDaliliZaMaambukiziLayout)
        btnNNDZMYV.setOnClickListener {
            onClick(btnNNDZMYV)
        }
        JinsiGaniVVUHushambuliaLayout = view.findViewById(R.id.JinsiGaniVVUHushambuliaLayout)
        btnJGVHK.setOnClickListener {
            onClick(btnJGVHK)
        }
        VVUInawezajeKuzuiwaLayout = view.findViewById(R.id.VVUInawezajeKuzuiwaLayout)
        btnVIZ.setOnClickListener {
            onClick(btnVIZ)
        }
        VVUInawezaKutibiwaLayout = view.findViewById(R.id.VVUInawezaKutibiwaLayout)
        btnVIK.setOnClickListener {
            onClick(btnVIK)
        }
        MawazoPotofuLayout = view.findViewById(R.id.MawazoPotofuLayout)
        btnMPKV.setOnClickListener {
            onClick(btnMPKV)
        }
        KuishiNaVVULayout = view.findViewById(R.id.KuishiNaVVULayout)
        btnKNV.setOnClickListener {
            onClick(btnKNV)
        }

        whatIsHIVText.text = resources.getString(R.string.what_is_hiv)
        VVUHuambukizwavipiText.text = resources.getString(R.string.how_is_hiv_transmitted)
        NiNiniKinakuwekaHatariniText.text = resources.getString(R.string.what_puts_you_at_risk)
        NiNiniDaliliZaMaambukiziText.text = resources.getString(R.string.what_are_the_symptomps_of_hiv_infection)
        JinsiGaniVVUHushambuliaText.text = resources.getString(R.string.how_hiv_attacks_the_immune_system)
        VVUInawezajeKuzuiwaText.text = resources.getString(R.string.how_can_hiv_be_prevented)
        KuishiNaVVUText.text = resources.getString(R.string.living_with_hiv)
        VVUInawezaKutibiwaText.text = resources.getString(R.string.is_hiv_treatable)
        MawazoPotofuText.text = resources.getString(R.string.myth_about_HIV)

        return view
    }

    fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btnWIH -> {
                    whatIsHIVLayout?.toggle()
                    VVUHuambukizwavipiLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                    NINiniDaliliZaMaambukiziLayout?.collapse()
                    JinsiGaniVVUHushambuliaLayout?.collapse()
                    VVUInawezajeKuzuiwaLayout?.collapse()
                    KuishiNaVVULayout?.collapse()
                    VVUInawezaKutibiwaLayout?.collapse()
                    MawazoPotofuLayout?.collapse()
                }

                R.id.btnVHV -> {
                    VVUHuambukizwavipiLayout?.toggle()
                    whatIsHIVLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                    NINiniDaliliZaMaambukiziLayout?.collapse()
                    JinsiGaniVVUHushambuliaLayout?.collapse()
                    VVUInawezajeKuzuiwaLayout?.collapse()
                    KuishiNaVVULayout?.collapse()
                    VVUInawezaKutibiwaLayout?.collapse()
                    MawazoPotofuLayout?.collapse()
                }

                R.id.btnNNKH -> {
                    NiNiniKinakuwekaHatariniLayout?.toggle()
                    whatIsHIVLayout?.collapse()
                    VVUHuambukizwavipiLayout?.collapse()
                    NINiniDaliliZaMaambukiziLayout?.collapse()
                    JinsiGaniVVUHushambuliaLayout?.collapse()
                    VVUInawezajeKuzuiwaLayout?.collapse()
                    KuishiNaVVULayout?.collapse()
                    VVUInawezaKutibiwaLayout?.collapse()
                    MawazoPotofuLayout?.collapse()
                }

                R.id.btnNNDZMYV -> {
                    NINiniDaliliZaMaambukiziLayout?.toggle()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                    whatIsHIVLayout?.collapse()
                    VVUHuambukizwavipiLayout?.collapse()
                    JinsiGaniVVUHushambuliaLayout?.collapse()
                    KuishiNaVVULayout?.collapse()
                    VVUInawezaKutibiwaLayout?.collapse()
                    VVUInawezajeKuzuiwaLayout?.collapse()
                    MawazoPotofuLayout?.collapse()
                }

                R.id.btnJGVHK -> {
                    JinsiGaniVVUHushambuliaLayout?.toggle()
                    NINiniDaliliZaMaambukiziLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                    whatIsHIVLayout?.collapse()
                    VVUHuambukizwavipiLayout?.collapse()
                    VVUInawezajeKuzuiwaLayout?.collapse()
                    KuishiNaVVULayout?.collapse()
                    VVUInawezaKutibiwaLayout?.collapse()
                    MawazoPotofuLayout?.collapse()
                }

                R.id.btnVIZ -> {
                    VVUInawezajeKuzuiwaLayout?.toggle()
                    NINiniDaliliZaMaambukiziLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                    whatIsHIVLayout?.collapse()
                    VVUHuambukizwavipiLayout?.collapse()
                    JinsiGaniVVUHushambuliaLayout?.collapse()
                    KuishiNaVVULayout?.collapse()
                    VVUInawezaKutibiwaLayout?.collapse()
                    MawazoPotofuLayout?.collapse()
                }

                R.id.btnKNV -> {
                    KuishiNaVVULayout?.toggle()
                    NINiniDaliliZaMaambukiziLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                    whatIsHIVLayout?.collapse()
                    VVUHuambukizwavipiLayout?.collapse()
                    VVUInawezajeKuzuiwaLayout?.collapse()
                    JinsiGaniVVUHushambuliaLayout?.collapse()
                    VVUInawezaKutibiwaLayout?.collapse()
                    MawazoPotofuLayout?.collapse()
                }

                R.id.btnVIK -> {
                    VVUInawezaKutibiwaLayout?.toggle()
                    KuishiNaVVULayout?.collapse()
                    NINiniDaliliZaMaambukiziLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                    whatIsHIVLayout?.collapse()
                    VVUHuambukizwavipiLayout?.collapse()
                    JinsiGaniVVUHushambuliaLayout?.collapse()
                    VVUInawezajeKuzuiwaLayout?.collapse()
                    MawazoPotofuLayout?.collapse()
                }

                R.id.btnMPKV -> {
                    MawazoPotofuLayout?.toggle()
                    VVUInawezajeKuzuiwaLayout?.collapse()
                    KuishiNaVVULayout?.collapse()
                    NINiniDaliliZaMaambukiziLayout?.collapse()
                    NiNiniKinakuwekaHatariniLayout?.collapse()
                    whatIsHIVLayout?.collapse()
                    VVUHuambukizwavipiLayout?.collapse()
                    JinsiGaniVVUHushambuliaLayout?.collapse()
                    VVUInawezaKutibiwaLayout?.collapse()
                }

                else -> {

                }
            }
        }
        initmyLayout()
    }

}
