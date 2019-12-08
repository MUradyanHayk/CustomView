package com.example.mycustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.ViewGroup
import android.widget.FrameLayout

class MyItemLayout(context: Context) : FrameLayout(context) {
    private var myTextView: MyTextView? = null

    init {
        myTextView = MyTextView(context)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setBackgroundColor(Color.RED)
        addView(myTextView)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        myTextView?.measure(widthMeasureSpec, 2 * myTextView?.viewHeight!!)
        setMeasuredDimension(widthMeasureSpec, 2 * myTextView?.viewHeight!!)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        myTextView?.layout(left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.save()
        myTextView?.draw(canvas)
        canvas?.restore()
    }

    fun configure(firstName: String, secondName: String) {
        myTextView?.configure(firstName, secondName)
    }
}