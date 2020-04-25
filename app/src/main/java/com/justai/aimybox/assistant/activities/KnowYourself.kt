package com.justai.aimybox.assistant.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewTreeObserver
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.aakira.expandablelayout.ExpandableLinearLayout
import com.justai.aimybox.assistant.MainActivity
import com.justai.aimybox.assistant.R
import kotlinx.android.synthetic.main.fragment_know_yourself.*
import kotlinx.android.synthetic.main.know_yourself_layout.*

class KnowYourself : AppCompatActivity(), View.OnClickListener {

    internal var expPubertyLayout: ExpandableLinearLayout? = null
    internal var expReproductiveOrgaLayout: ExpandableLinearLayout? = null
    internal var expSemenLayout: ExpandableLinearLayout? = null
    internal var expSpermLayout: ExpandableLinearLayout? = null
    internal var expHormonesLayout: ExpandableLinearLayout? = null

    companion object{
        val EXTRA_CIRCULAR_REVEAL_X = "EXTRA_CIRCULAR_REVEAL_X"
        val EXTRA_CIRCULAR_REVEAL_Y = "EXTRA_CIRCULAR_REVEAL_Y"
    }

    lateinit var rootLayout: ConstraintLayout

    private var revealX = 0
    private var revealY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.know_yourself_layout)

        val intent: Intent = intent

        rootLayout = findViewById(R.id.root_layout)


        if (savedInstanceState == null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
            intent.hasExtra(EXTRA_CIRCULAR_REVEAL_X) &&
            intent.hasExtra(EXTRA_CIRCULAR_REVEAL_Y)
        ) {
            rootLayout.visibility = View.INVISIBLE
            revealX = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_X, 0)
            revealY = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_Y, 0)
            val viewTreeObserver = rootLayout.viewTreeObserver
            if (viewTreeObserver.isAlive) {
                viewTreeObserver.addOnGlobalLayoutListener(object :
                    ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        revealActivity(revealX, revealY)
                        rootLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                })
            }

//            rootLayout.setBackgroundColor(Color.parseColor("#ffffff"))

        } else {
            rootLayout.visibility = View.VISIBLE

        }

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

    protected fun revealActivity(x: Int, y: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val finalRadius = (Math.max(
                rootLayout.width,
                rootLayout.height
            ) * 1.1).toFloat()

            // create the animator for this view (the start radius is zero)
            val circularReveal =
                ViewAnimationUtils.createCircularReveal(rootLayout, x, y, 0f, finalRadius)
            circularReveal.duration = 600
            circularReveal.interpolator = AccelerateInterpolator()

            // make the view visible and start the animation
            rootLayout.visibility = View.VISIBLE
            circularReveal.start()
        } else {
            finish()
        }
    }

    protected fun unRevealActivity() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            finish()
        } else {
            val finalRadius = (Math.max(
                rootLayout.width,
                rootLayout.height
            ) * 1.1).toFloat()
            val circularReveal =
                ViewAnimationUtils.createCircularReveal(
                    rootLayout, revealX, revealY, finalRadius, 0f
                )
            circularReveal.duration = 800
            circularReveal.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    rootLayout.visibility = View.INVISIBLE
                    val intent = Intent(this@KnowYourself, MainActivity::class.java)
//                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
//                    startActivity(intent)
                    finish()
                }
            })
            circularReveal.start()
//            startActivity()
        }
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

    override fun onBackPressed() {
//        super.onBackPressed()
        unRevealActivity()
    }
}