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

class KnowYourself : AppCompatActivity() , View.OnClickListener {

    internal var expPubertyLayout: ExpandableLinearLayout? = null
    internal var expReproductiveOrgaLayout: ExpandableLinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.know_yourself_layout)

        val toolbar : Toolbar = findViewById(R.id.tool_bar2)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        // get the support action bar
        val actionBar = supportActionBar
        actionBar?.setIcon(R.drawable.ic_chevron_left_gray_24dp)

        // Expendale buttons and Layouts
        expPubertyLayout = findViewById(R.id.pubertyLayout)
        btnPuberty?.setOnClickListener(this)

        expReproductiveOrgaLayout = findViewById(R.id.reproductiveOrgansLayout)
        btnReproductiveOrgans?.setOnClickListener(this)

        expandedtext.text = resources.getString(R.string.puberty)
        expandedtext2.text = resources.getString(R.string.puberty)

    }

    private fun initmyLayout() {
        expPubertyLayout?.initLayout()
        expReproductiveOrgaLayout?.initLayout()
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btnPuberty -> { expPubertyLayout?.toggle()
                expReproductiveOrgaLayout?.collapse()
            }

            R.id.btnReproductiveOrgans -> { expReproductiveOrgaLayout?.toggle()
                expPubertyLayout?.collapse()
            }

            else -> {

            }
        }
        initmyLayout()
    }
}