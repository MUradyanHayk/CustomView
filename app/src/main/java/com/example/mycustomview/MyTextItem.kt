package com.example.mycustomview

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.view.View

class MyTextItem {
    private var staticLayout: StaticLayout? = null
    private val paint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    private val rect = Rect()

    var text = "dddddddd"

    val width: Int
        get() = staticLayout?.width ?: 0

    val height: Int
        get() = staticLayout?.height ?: 0

    var textSize: Float
        get() = paint.textSize
        set(value) {
            paint.textSize = value
        }

    var color: Int
        get() = paint.color
        set(value) {
            paint.color = value
        }

    var bgColor: Int
        get() = paint.bgColor
        set(value) {
            paint.bgColor = value
        }

    init {
        with(paint) {
            textSize = 100f
            color = Color.BLACK
            bgColor = Color.WHITE
        }
    }

    fun layout(l: Int, t: Int, r: Int, b: Int) {
        with(rect) {
            left = l
            top = t
            right = r
            bottom = b
        }
    }

    fun measure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        staticLayout =
            StaticLayout(
                text,
                paint,
                View.MeasureSpec.getSize(widthMeasureSpec),
                Layout.Alignment.ALIGN_NORMAL,
                1f,
                0f,
                false
            )
    }

    fun draw(canvas: Canvas?) {
        staticLayout?.draw(canvas)
        canvas?.translate(rect.top.toFloat(), rect.bottom.toFloat())
    }
}