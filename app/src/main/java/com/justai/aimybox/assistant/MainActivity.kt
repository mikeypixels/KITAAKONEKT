package com.justai.aimybox.assistant

import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.justai.aimybox.components.AimyboxAssistantFragment
import kotlinx.android.synthetic.main.layout_activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_main)

        val toolbar : Toolbar = findViewById(R.id.tool_bar)
        toolbar.title = "Home"
        setSupportActionBar(toolbar)

        // Now get the support action bar
        val actionBar = supportActionBar

        actionBar?.elevation = 4.0F
        actionBar?.setIcon(R.drawable.ic_menu_black_24dp)
        actionBar?.setDisplayShowTitleEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        // Set the toolbar as support action bar

//        supportActionBar?.title = "Mama"
//        collapsing_toolbar.title = "Nana"
//        collapsing_toolbar.isTitleEnabled = true

        // Now get the support action bar
//        val actionBar = supportActionBar

        // Set toolbar title/app title
//        actionBar!!.title = "Hello APP"

        // Set action bar/toolbar sub title
        //actionBar.subtitle = "App subtitle"

        // Set action bar elevation
//        actionBar.elevation = 4.0F

        // Display the app icon in action bar/toolbar
//        actionBar.setDisplayShowHomeEnabled(true)
//        actionBar.setLogo(R.mipmap.kitaakonekt_logo)
//        actionBar.setDisplayUseLogoEnabled(true)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val assistantFragment = AimyboxAssistantFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.assistant_container, assistantFragment)
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        val assistantFragment = (supportFragmentManager.findFragmentById(R.id.assistant_container)
                as? AimyboxAssistantFragment)
        if (assistantFragment?.onBackPressed() != true) super.onBackPressed()
    }

}