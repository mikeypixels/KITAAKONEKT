package com.justai.aimybox.assistant

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import kotlinx.android.synthetic.main.know_yourself_layout.*
import kotlinx.android.synthetic.main.layout_activity_main.*

class KnowYourself : AppCompatActivity(), View.OnClickListener {

    internal var expPubertyLayout: ExpandableLinearLayout? = null
    internal var expReproductiveOrgaLayout: ExpandableLinearLayout? = null
    internal var expSemenLayout: ExpandableLinearLayout? = null
    internal var expSpermLayout: ExpandableLinearLayout? = null
    internal var expHormonesLayout: ExpandableLinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.know_yourself_layout)

        val toolbar: Toolbar = findViewById(R.id.tool_bar2)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        // get the support action bar
        val actionBar = supportActionBar
        actionBar?.setIcon(R.drawable.ic_chevron_left_gray_24dp)

        // Expendable buttons and Layouts
        expPubertyLayout = findViewById(R.id.pubertyLayout)
        btnPuberty?.setOnClickListener(this)

        expReproductiveOrgaLayout = findViewById(R.id.reproductiveOrgansLayout)
        btnReproductiveOrgans?.setOnClickListener(this)

        expSemenLayout = findViewById(R.id.semenLayout)
        btnSemen?.setOnClickListener(this)

        expSpermLayout = findViewById(R.id.spermLayout)
        btnSperm?.setOnClickListener(this)

        expHormonesLayout = findViewById(R.id.hormonesLayout)
        btnHormones?.setOnClickListener(this)

        pubertyText.text = resources.getString(R.string.puberty)
        reproductiveOrganText.text = resources.getString(R.string.puberty)
        semenText.text = resources.getString(R.string.puberty)
        spermText.text = resources.getString(R.string.puberty)
        hormonesText.text = resources.getString(R.string.puberty)

    }

    private fun initmyLayout() {
        expPubertyLayout?.initLayout()
        expReproductiveOrgaLayout?.initLayout()
        expSemenLayout?.initLayout()
        expSpermLayout?.initLayout()
        expHormonesLayout?.initLayout()
    }

    override fun onClick(v: View?) {

        when (v?.id) {
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
        initmyLayout()
    }
}