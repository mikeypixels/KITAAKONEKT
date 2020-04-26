package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.utils.ExitWithAnimation
import com.justai.aimybox.assistant.utils.startCircularReveal
import kotlinx.android.synthetic.main.fragment_know_yourself.*


/**
 * A simple [Fragment] subclass.
 */
class KnowYourselfFragment : Fragment(), ExitWithAnimation {

    internal var expPubertyLayout: ExpandableLinearLayout? = null
    internal var expReproductiveOrgaLayout: ExpandableLinearLayout? = null
    internal var expSemenLayout: ExpandableLinearLayout? = null
    internal var expSpermLayout: ExpandableLinearLayout? = null
    internal var expHormonesLayout: ExpandableLinearLayout? = null

    override var posX: Int? = null
    override var posY: Int? = null

    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): KnowYourselfFragment = KnowYourselfFragment().apply {
            if (exit != null && exit.size == 2) {
                posX = exit[0]
                posY = exit[1]

                System.out.println("This is the positions in Fragment: " + posX + " and " + posY)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_know_yourself, container, false)

//        RevealCircleAnimatorHelper
//            .create(this, container)
//            .start(view)

        val toolbar: Toolbar = view.findViewById(R.id.tool_bar2)
        toolbar.title = ""

        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        // get the support action bar
        val actionBar = (activity as AppCompatActivity?)!!.supportActionBar
        actionBar?.setIcon(R.drawable.ic_chevron_left_gray_24dp)

        val pubertyText: TextView = view.findViewById(R.id.pubertyText)
        val reproductiveOrganText: TextView = view.findViewById(R.id.reproductiveOrganText)
        val semenText: TextView = view.findViewById(R.id.semenText)
        val spermText: TextView = view.findViewById(R.id.spermText)
        val hormonesText: TextView = view.findViewById(R.id.pubertyText)

        val btnPuberty: Button = view.findViewById(R.id.btnPuberty)
        val btnReproductiveOrgans: Button = view.findViewById(R.id.btnReproductiveOrgans)
        val btnSemen: Button = view.findViewById(R.id.btnSemen)
        val btnSperm: Button = view.findViewById(R.id.btnSperm)
        val btnHormones: Button = view.findViewById(R.id.btnHormones)

        // Expendable buttons and Layouts
        expPubertyLayout = view.findViewById(R.id.pubertyLayout)
        btnPuberty.setOnClickListener{
            onClick(btnPuberty)
        }

        expReproductiveOrgaLayout = view.findViewById(R.id.reproductiveOrgansLayout)
        btnReproductiveOrgans.setOnClickListener{
            onClick(btnReproductiveOrgans)
        }

        expSemenLayout = view.findViewById(R.id.semenLayout)
        btnSemen.setOnClickListener{
            onClick(btnSemen)
        }

        expSpermLayout = view.findViewById(R.id.spermLayout)
        btnSperm.setOnClickListener{
            onClick(btnSperm)
        }

        expHormonesLayout = view.findViewById(R.id.hormonesLayout)
        btnHormones.setOnClickListener{
            onClick(btnHormones)
        }

        pubertyText.text = resources.getString(R.string.puberty)
        reproductiveOrganText.text = resources.getString(R.string.puberty)
        semenText.text = resources.getString(R.string.puberty)
        spermText.text = resources.getString(R.string.puberty)
        hormonesText.text = resources.getString(R.string.puberty)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(false, posX as Int, posY as Int)
    }

    private fun initmyLayout() {
        expPubertyLayout?.initLayout()
        expReproductiveOrgaLayout?.initLayout()
        expSemenLayout?.initLayout()
        expSpermLayout?.initLayout()
        expHormonesLayout?.initLayout()
    }

    fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btnPuberty -> {
                    expPubertyLayout?.toggle()
                    expReproductiveOrgaLayout?.collapse()
                    expSemenLayout?.collapse()
                    expSpermLayout?.collapse()
                    expHormonesLayout?.collapse()
                }

                R.id.btnReproductiveOrgans -> {
                    expReproductiveOrgaLayout?.toggle()
                    expPubertyLayout?.collapse()
                    expSemenLayout?.collapse()
                    expSpermLayout?.collapse()
                    expHormonesLayout?.collapse()
                }

                R.id.btnSemen -> {
                    expSemenLayout?.toggle()
                    expPubertyLayout?.collapse()
                    expReproductiveOrgaLayout?.collapse()
                    expSpermLayout?.collapse()
                    expHormonesLayout?.collapse()
                }

                R.id.btnSperm -> {
                    expSpermLayout?.toggle()
                    expSemenLayout?.collapse()
                    expPubertyLayout?.collapse()
                    expReproductiveOrgaLayout?.collapse()
                    expHormonesLayout?.collapse()
                }

                R.id.btnHormones -> {
                    expHormonesLayout?.toggle()
                    expSpermLayout?.collapse()
                    expSemenLayout?.collapse()
                    expPubertyLayout?.collapse()
                    expReproductiveOrgaLayout?.collapse()
                }

                else -> {

                }
            }
        }
        initmyLayout()
    }

}