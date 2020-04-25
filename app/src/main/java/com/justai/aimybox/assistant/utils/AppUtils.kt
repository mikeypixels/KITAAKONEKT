package com.justai.aimybox.assistant.utils

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.Rect
import android.view.View


object AppUtils {
    fun takeScreenShot(activity: Activity): Bitmap {
        val view: View = activity.window.decorView
        view.setDrawingCacheEnabled(true)
        view.buildDrawingCache()
        val b1: Bitmap = view.getDrawingCache()
        val frame = Rect()
        activity.window.decorView.getWindowVisibleDisplayFrame(frame)
        val statusBarHeight: Int = frame.top
        val display = activity.windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width: Int = size.x
        val height: Int = size.y
        val b: Bitmap = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight)
        view.destroyDrawingCache()
        return b
    }
}