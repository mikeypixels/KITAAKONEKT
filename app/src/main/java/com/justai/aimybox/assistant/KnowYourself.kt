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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.know_yourself_layout)

        val toolbar : Toolbar = findViewById(R.id.tool_bar2)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        // Now get the support action bar
        val actionBar = supportActionBar

        actionBar?.setIcon(R.drawable.ic_chevron_left_gray_24dp)

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