package com.justai.aimybox.assistant.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.justai.aimybox.assistant.R
import com.justai.aimybox.assistant.adapters.ForumTabViewAdapter


class ForumActivity : AppCompatActivity() {

//    private val tabIcons = intArrayOf(
//        R.drawable.ic_tab_favourite,
//        R.drawable.ic_tab_call,
//        R.drawable.ic_tab_contacts
//    )

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        val w = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val myTabViewAdapter =
            ForumTabViewAdapter(
                supportFragmentManager
            )
        viewPager.adapter = myTabViewAdapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }

//    override fun onBackPressed() {
//        val intent: Intent = Intent(this@ForumActivity, MainActivity::class.java)
//        startActivity(intent)
//        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
//    }

    //Adding drawable vector to tabs
//    private fun setupTabIcons() {
//        tabLayout.getTabAt(0).setIcon(tabIcons.get(0))
//        tabLayout.getTabAt(1).setIcon(tabIcons.get(1))
//        tabLayout.getTabAt(2).setIcon(tabIcons.get(2))
//    }
}
