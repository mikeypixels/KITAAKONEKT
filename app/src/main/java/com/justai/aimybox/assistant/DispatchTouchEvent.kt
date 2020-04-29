package com.justai.aimybox.assistant

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.core.widget.NestedScrollView


class DispatchTouchEvent(context: Context): NestedScrollView(context){

    interface onDispatchEvent {
        fun dispatchEvent(e: MotionEvent?)
    }

    private var dispatchEvent: onDispatchEvent? = null

    fun DispatchTouchEvent(context: Context?) {
        DispatchTouchEvent(context)
    }

    fun DispatchTouchEvent(context: Context?, attrs: AttributeSet?) {
        DispatchTouchEvent(context, attrs)
    }

    fun DispatchTouchEvent(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) {
        DispatchTouchEvent(context, attrs, defStyleAttr)
    }

    fun setDispatchEvent(dispatchEvent: onDispatchEvent?) {
        this.dispatchEvent = dispatchEvent
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (dispatchEvent != null) {
            dispatchEvent!!.dispatchEvent(ev)
        }
        return super.dispatchTouchEvent(ev)
    }

}