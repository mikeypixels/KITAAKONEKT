package com.justai.aimybox.assistant.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.utils.ExitWithAnimation

class FamilyPlanFragment : Fragment(), ExitWithAnimation {

    private var expPermanentContraLayout: ExpandableLinearLayout? = null
    private var expTemporaryContraLayout: ExpandableLinearLayout? = null
    private var expEmergencyContraLayout: ExpandableLinearLayout? = null

    lateinit var btnPermanentContra: Button
    lateinit var btnTemporaryContra: Button
    lateinit var btnEmergencyContra: Button

    override var posX: Int? = null
    override var posY: Int? = null

    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): FamilyPlanFragment = FamilyPlanFragment().apply {
            if (exit != null && exit.size == 2) {
                posX = exit[0]
                posY = exit[1]

                System.out.println("This is the positions in Fragment: " + posX + " and " + posY)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_family_plan, container, false)

        val toolbar: Toolbar = view.findViewById(R.id.tool_bar2)
        toolbar.title = ""

        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        // get the support action bar
        val actionBar = (activity as AppCompatActivity?)!!.supportActionBar
        actionBar?.setIcon(R.drawable.ic_chevron_left_gray_24dp)

        //Buttons
        btnPermanentContra = view.findViewById(R.id.btnPermanentContraception)
        btnTemporaryContra = view.findViewById(R.id.btnTemporaryContraception)
        btnEmergencyContra = view.findViewById(R.id.btnEmergencyContraception)

        //Expendable buttons and Layouts
        expPermanentContraLayout = view.findViewById(R.id.permanentContraLayout)
        btnPermanentContra.setOnClickListener{
            onClick(btnPermanentContra)
        }

        expTemporaryContraLayout = view.findViewById(R.id.tempoContraLayout)
        btnTemporaryContra.setOnClickListener{
            onClick(btnTemporaryContra)
        }

        expEmergencyContraLayout = view.findViewById(R.id.emergencyLayout)
        btnEmergencyContra.setOnClickListener{
            onClick(btnEmergencyContra)
        }

        return view
    }

    private fun initmyLayout() {
        expPermanentContraLayout?.initLayout()
        expTemporaryContraLayout?.initLayout()
        expEmergencyContraLayout?.initLayout()
//        expSpermLayout?.initLayout()
//        expHormonesLayout?.initLayout()
    }

    private fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btnPermanentContraception -> {

                    expPermanentContraLayout?.toggle()
                    expTemporaryContraLayout?.collapse()
                    expEmergencyContraLayout?.collapse()
                }

                R.id.btnTemporaryContraception -> {
                    expPermanentContraLayout?.collapse()
                    expTemporaryContraLayout?.toggle()
                    expEmergencyContraLayout?.collapse()
                }

                R.id.btnEmergencyContraception -> {
                    expPermanentContraLayout?.collapse()
                    expTemporaryContraLayout?.collapse()
                    expEmergencyContraLayout?.toggle()
                }

                else -> {

                }
            }
        }
        initmyLayout()
    }
}