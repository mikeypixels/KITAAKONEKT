package com.justai.aimybox.assistant.activities

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

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
