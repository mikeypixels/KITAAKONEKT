package com.justai.aimybox.assistant

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import kotlinx.android.synthetic.main.know_yourself_layout.*
import kotlinx.android.synthetic.main.layout_activity_main.*

class KnowYourself : AppCompatActivity() , View.OnClickListener {

    internal var expandableListView: ExpandableLinearLayout? = null
    internal var expandableLayout: ExpandableLinearLayout? = null
    internal var expandableButton: Button? = null


    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null

    private val data: HashMap<String, List<String>>

        get() {
            val listData = HashMap<String, List<String>>()

            val redmiMobiles = ArrayList<String>()
            redmiMobiles.add("Redmi Y2")
            redmiMobiles.add("Redmi S2")
            redmiMobiles.add("Redmi Note 5 Pro")
            redmiMobiles.add("Redmi Note 5")
            redmiMobiles.add("Redmi 5 Plus")
            redmiMobiles.add("Redmi Y1")
            redmiMobiles.add("Redmi 3S Plus")

            val micromaxMobiles = ArrayList<String>()
            micromaxMobiles.add("Micromax Bharat Go")
            micromaxMobiles.add("Micromax Bharat 5 Pro")
            micromaxMobiles.add("Micromax Bharat 5")
            micromaxMobiles.add("Micromax Canvas 1")
            micromaxMobiles.add("Micromax Dual 5")

            val appleMobiles = ArrayList<String>()
            appleMobiles.add("iPhone 8")
            appleMobiles.add("iPhone 8 Plus")
            appleMobiles.add("iPhone X")
            appleMobiles.add("iPhone 7 Plus")
            appleMobiles.add("iPhone 7")
            appleMobiles.add("iPhone 6 Plus")

            val samsungMobiles = ArrayList<String>()
            samsungMobiles.add("Samsung Galaxy S9+")
            samsungMobiles.add("Samsung Galaxy Note 7")
            samsungMobiles.add("Samsung Galaxy Note 5 Dual")
            samsungMobiles.add("Samsung Galaxy S8")
            samsungMobiles.add("Samsung Galaxy A8")
            samsungMobiles.add("Samsung Galaxy Note 4")

            listData["Redmi"] = redmiMobiles
            listData["Micromax"] = micromaxMobiles
            listData["Apple"] = appleMobiles
            listData["Samsung"] = samsungMobiles

            return listData
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.know_yourself_layout)

        val toolbarr : Toolbar = findViewById(R.id.tool_bar2)
        toolbarr.title = ""
        setSupportActionBar(toolbarr)

        // Now get the support action bar
        val actionBar = supportActionBar

//        getActionBar()?.elevation = 4.0F
        actionBar?.setIcon(R.drawable.ic_chevron_left_gray_24dp)
//        actionBar?.setDisplayShowTitleEnabled(true)
//        actionBar?.setDisplayShowHomeEnabled(true)


        expandableListView = findViewById(R.id.expandableLayout1)
        expandableButton = findViewById(R.id.btn1)
        expandableButton?.setOnClickListener(this)

        expandableLayout = findViewById(R.id.expandableLayout2)
        expandableButton = findViewById(R.id.btn2)
        expandableButton?.setOnClickListener(this)


        expandedtext.text = resources.getString(R.string.puberty)
        expandedtext2.text = resources.getString(R.string.puberty)

    }

    private fun initmyLayout() {
        expandableListView?.initLayout()
        expandableLayout?.initLayout()
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn1 -> { expandableListView?.toggle()
                expandableLayout?.collapse()
            }

            R.id.btn2 -> { expandableLayout?.toggle()
                expandableListView?.collapse()
            }

            else -> {

            }
        }
        initmyLayout()
    }
}