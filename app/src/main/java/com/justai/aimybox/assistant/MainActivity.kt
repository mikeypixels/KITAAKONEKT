package com.justai.aimybox.assistant

import android.graphics.*
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.justai.aimybox.assistant.fragments.DashboardFragment
import com.justai.aimybox.assistant.utils.ExitWithAnimation
import com.justai.aimybox.assistant.utils.exitCircularReveal
import com.justai.aimybox.assistant.utils.open
import com.justai.aimybox.components.AimyboxAssistantFragment


class MainActivity : AppCompatActivity() {

    companion object {
        var screenData: Double = 0.0
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_main)

        screenData = getScreenDimension()

        val w = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            val window: Window = getWindow()
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.statusBarColor = Color.WHITE
//        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
//        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white)) // set status background white

        supportFragmentManager.open {
            replace(R.id.container_layout, DashboardFragment.newInstance())
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val assistantFragment = AimyboxAssistantFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.assistant_container, assistantFragment)
            commit()
        }
    }

    fun onFocusedEditText(focEditText: EditText, focEditTextCard: MaterialCardView, editText1Card: MaterialCardView, editText2Card: MaterialCardView, editText3Card: MaterialCardView){
        focEditText.setOnFocusChangeListener { v, hasFocus ->
            focEditTextCard.setStrokeColor(Color.BLUE)
            focEditTextCard.scaleY = 1.05f
            focEditTextCard.scaleX = 1.05f
            focEditText.setPadding(35, 0, 35, 0)
            editText1Card.setStrokeColor(Color.WHITE)
            editText1Card.scaleX = 1f
            editText1Card.scaleY = 1f
            editText2Card.setStrokeColor(Color.WHITE)
            editText2Card.scaleX = 1f
            editText2Card.scaleY = 1f
            editText3Card.setStrokeColor(Color.WHITE)
            editText3Card.scaleX = 1f
            editText3Card.scaleY = 1f
        }
    }

    fun changeBitmapContrastBrightness(
        bmp: Bitmap,
        contrast: Float,
        brightness: Float
    ): Bitmap? {
        val cm = ColorMatrix(
            floatArrayOf(
                contrast,
                0f,
                0f,
                0f,
                brightness,
                0f,
                contrast,
                0f,
                0f,
                brightness,
                0f,
                0f,
                contrast,
                0f,
                brightness,
                0f,
                0f,
                0f,
                1f,
                0f
            )
        )
        val ret: Bitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig())
        val canvas = Canvas(ret)
        val paint = Paint()
        paint.setColorFilter(ColorMatrixColorFilter(cm))
        canvas.drawBitmap(bmp, 0F, 0F, paint)
        return ret
    }

//    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
//        if (event.action == MotionEvent.ACTION_DOWN) {
//            if (DashboardFragment.bsb.getState() === BottomSheetBehavior.STATE_EXPANDED) {
//                val outRect = Rect()
//                DashboardFragment.bs.getGlobalVisibleRect(outRect)
//                if (!outRect.contains(
//                        event.rawX.toInt(),
//                        event.rawY.toInt()
//                    )
//                ) DashboardFragment.bsb.setState(BottomSheetBehavior.STATE_COLLAPSED)
//            }
//        }
//        return super.dispatchTouchEvent(event)
//    }

    private fun getScreenDimension(): Double {
        val dm = DisplayMetrics()
        this.getWindowManager().getDefaultDisplay().getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        val dens = dm.densityDpi
        val wi = width.toDouble() / dens.toDouble()
        val hi = height.toDouble() / dens.toDouble()
        val x = Math.pow(wi, 2.0)
        val y = Math.pow(hi, 2.0)
        val screenInches = Math.sqrt(x + y)

        return screenInches
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        val assistantFragment = (supportFragmentManager.findFragmentById(R.id.assistant_container)
                as? AimyboxAssistantFragment)
        if (assistantFragment?.onBackPressed() != true){
//            super.onBackPressed()
            with(supportFragmentManager.findFragmentById(R.id.container_layout)) {
                // Check if the current fragment implements the [ExitWithAnimation] interface or not
                // Also check if the [ExitWithAnimation.isToBeExitedWithAnimation] is `true` or not
                if ((this as? ExitWithAnimation)?.isToBeExitedWithAnimation() == true) {
                    if (this.posX == null || this.posY == null) {
                        super.onBackPressed()
                    } else {
                        this.view?.exitCircularReveal(this.posX!!, this.posY!!) {
                            super.onBackPressed()
                        } ?: super.onBackPressed()
                    }
                } else {
                    super.onBackPressed()
                }
            }
        }
    }

}