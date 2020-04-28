package com.justai.aimybox.assistant.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.graphics.Rect
import android.view.View
import android.view.ViewAnimationUtils
import android.view.Window
import android.view.animation.DecelerateInterpolator
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.justai.aimybox.assistant.fragments.DashboardFragment

/**
 * Starts circular reveal animation
 * [fromLeft] if `true` then start animation from the bottom left of the [View] else start from the bottom right
 */
fun View.startCircularReveal(fromLeft: Boolean, posX: Int, posY: Int) {
    addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
        override fun onLayoutChange(v: View, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int,
                                    oldRight: Int, oldBottom: Int) {
            v.removeOnLayoutChangeListener(this)
//             TODO: Inject this from arguments
            val cx = if (fromLeft) posX else posX
            val cy = posY
//            System.out.println("The layout on new top is: $top and on y: $bottom while The layout on old top is: $oldTop and on y: $oldBottom")
            val radius = Math.hypot(right.toDouble(), bottom.toDouble()).toInt()
            ViewAnimationUtils.createCircularReveal(v, cx, cy, 0f, radius.toFloat()).apply {
                interpolator = DecelerateInterpolator(1f)
                duration = 1000
                start()
            }
        }
    })
}

/**
 * Animate fragment exit using given parameters as animation end point. Runs the given block of code
 * after animation completion.
 *
 * @param exitX: Animation end point X coordinate.
 * @param exitY: Animation end point Y coordinate.
 * @param block: Block of code to be executed on animation completion.
 */
fun View.exitCircularReveal(exitX: Int, exitY: Int, block: () -> Unit) {
    val startRadius = Math.hypot(this.width.toDouble(), this.height.toDouble())
    ViewAnimationUtils.createCircularReveal(this, exitX, exitY, startRadius.toFloat(), 0f).apply {
        duration = 800
        interpolator = DecelerateInterpolator(3f)
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                block()
                super.onAnimationEnd(animation)
            }
        })
        start()
    }
}

/**
 * @return the position of the current [View]'s center in the screen
 */
fun View.findLocationOfCenterOnTheScreen(): IntArray {
    val positions = intArrayOf(0, 0)
    getLocationInWindow(positions)
    System.out.println("The positions are: " + positions[0] + "and " + positions[1])
    // Get the center of the view
    positions[0] = positions[0] + width / 2

    if(DashboardFragment.bsb.state == BottomSheetBehavior.STATE_EXPANDED){
        positions[1] = positions[1] + height / 2
    }else{
        positions[1] = positions[1] + height / 2 - DashboardFragment.statusbarHeight
    }
    return positions
}

/**
 * Needs to be implemented by fragments that should exit with circular reveal
 * animation along with [isToBeExitedWithAnimation] returning true
 * @property posX the X-axis position of the center of circular reveal
 * @property posY the Y-axis position of the center of circular reveal
 */
interface ExitWithAnimation {
    var posX: Int?
    var posY: Int?
    /**
     * Must return true if required to exit with circular reveal animation
     */
    fun isToBeExitedWithAnimation(): Boolean
}