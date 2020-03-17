package com.justai.aimybox.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.layout_activity_main.*

class KnowYourself : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.know_yourself_layout)

        val toolbarr : Toolbar = findViewById(R.id.tool_bar2)
        toolbarr.title = ""
        setSupportActionBar(toolbarr)

        // Now get the support action bar
        val actionBar = supportActionBar

//        getActionBar()?.elevation = 4.0F
        actionBar?.setIcon(R.drawable.ic_arrow_back_gray_24dp)
//        actionBar?.setDisplayShowTitleEnabled(true)
//        actionBar?.setDisplayShowHomeEnabled(true)


    }
}