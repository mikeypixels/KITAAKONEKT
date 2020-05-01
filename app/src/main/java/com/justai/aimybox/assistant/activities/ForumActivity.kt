package com.justai.aimybox.assistant.activities

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.card.MaterialCardView
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

        val search_view = findViewById<SearchView>(R.id.search_view)
        val add_question = findViewById<RelativeLayout>(R.id.add_question)
        val add_img = findViewById<ImageView>(R.id.add_img)
        val add_txt= findViewById<TextView>(R.id.add_txt)

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

        findViewById<ImageView>(R.id.back_img).setOnClickListener {
            super.onBackPressed()
        }

        add_question.setOnClickListener {
            popUpAddQDialog(add_question)
        }

        add_img.setOnClickListener {
            popUpAddQDialog(add_img)
        }

        add_txt.setOnClickListener {
            popUpAddQDialog(add_txt)
        }

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }

    fun popUpAddQDialog(view: View) {
        view.setOnClickListener {

            lateinit var cLayout: ConstraintLayout

            val dialog = Dialog(this)
            val dm = resources.displayMetrics
            val width = dm.widthPixels
            val height = dm.heightPixels
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.add_question_layout)

            val editText = dialog.findViewById<EditText>(R.id.edit_txt)
            val send_btn = dialog.findViewById<MaterialCardView>(R.id.send_btn)
            val cancel = dialog.findViewById<ImageView>(R.id.cancel)

            cancel.setOnClickListener {
                dialog.cancel()
            }

            editText.layoutParams.height = (0.6 * height).toInt()

            editText.setOnFocusChangeListener(View.OnFocusChangeListener { v, hasFocus ->
                editText.post(Runnable {
                    val inputMethodManager: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.showSoftInput(
                        editText,
                        InputMethodManager.SHOW_IMPLICIT
                    )
                })
            })

            editText.requestFocus()

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations =
                R.style.DialogAnimation

            cLayout = dialog.findViewById(R.id.cLayout)
            cLayout.layoutParams.height = (0.9 * height).toInt()
            val lLayout_height = cLayout.layoutParams.height

            dialog.window!!.setLayout((width * .93).toInt(), lLayout_height)
            dialog.setCancelable(true)

            dialog.show()
        }
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
