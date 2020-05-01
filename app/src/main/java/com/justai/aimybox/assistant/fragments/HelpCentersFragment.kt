package com.justai.aimybox.assistant.fragments

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hanks.htextview.evaporate.EvaporateTextView
import com.justai.aimybox.assistant.HelpCenter
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.adapters.HelpCentersAdapter
import com.justai.aimybox.assistant.utils.ExitWithAnimation
import com.justai.aimybox.assistant.utils.startCircularReveal


class HelpCentersFragment : Fragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    var helpCentersArray: ArrayList<HelpCenter> = ArrayList()
    var arrMessages: ArrayList<String> = ArrayList()
    var position = 0
    var delay = 4000 //milliseconds


    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): HelpCentersFragment = HelpCentersFragment().apply {
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
        val view: View = inflater.inflate(R.layout.fragment_help_centers, container, false)

        val evap_txt: EvaporateTextView = view.findViewById(R.id.evap_txt)
        val recyclerView: RecyclerView = view.findViewById(R.id.help_centers_recyclerView)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager

        arrMessages.add("Je unahitaji msaada?")
        arrMessages.add("Bofya alama ya kupiga simu!")

        evap_txt.animateText(arrMessages.get(position))
        position++

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                handler.postDelayed(this, delay.toLong())
                if (position >= arrMessages.size)
                    position = 0
                evap_txt.animateText(arrMessages.get(position))
                position++
            }
        }, delay.toLong())

        helpCentersArray.add(HelpCenter("Benjamin Mkapa Hospital", "Dodoma", "026 296 3710"))
        helpCentersArray.add(HelpCenter("Aga Khan Hospital", "Dodoma", "026 232 1789"))
        helpCentersArray.add(HelpCenter("Regional Hospital", "Dodoma", "026 232 3045"))
        helpCentersArray.add(HelpCenter("Aga Khan Medical Centre", "Dodoma", "026 232 1789"))
        helpCentersArray.add(HelpCenter("Makole Hospital", "Dodoma", "026 232 3704"))
        helpCentersArray.add(HelpCenter("Amani Hospital", "Dodoma", "0620 770 606"))
        helpCentersArray.add(HelpCenter("Mackay Hospital", "Dodoma", "Unk"))
        helpCentersArray.add(HelpCenter("Avenues Medical Clinic", "Dodoma", "0713 400 128"))
        helpCentersArray.add(HelpCenter("Nkuhungu Community Hospital", "Dodoma", "Unk"))
        helpCentersArray.add(HelpCenter("Nesuda Medical Centre", "Dodoma", "0684 770 606"))

        val helpCentersAdapter = context?.let { HelpCentersAdapter(it, helpCentersArray) }
        recyclerView.adapter = helpCentersAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(false, posX as Int, posY as Int)
    }
}
