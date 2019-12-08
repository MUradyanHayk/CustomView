package com.example.mycustomview

import android.content.Context
import android.graphics.Canvas
import android.view.View

class MyTextView(context: Context) : View(context) {
    private var firstItem: MyTextItem? = null
    private var secondItem: MyTextItem? = null

    val viewHeight: Int?
        get() = firstItem?.height

    val viewWidht: Int?
        get() = firstItem?.width

    init {
        firstItem = MyTextItem()
        secondItem = MyTextItem()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        firstItem?.measure(widthMeasureSpec, heightMeasureSpec)
        secondItem?.measure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, height)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        firstItem?.layout(0, 0, firstItem?.width!!, firstItem?.height!!)
        secondItem?.layout(left, firstItem?.height!!, firstItem?.width!!, 2 * firstItem?.height!!)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        firstItem?.draw(canvas)
        secondItem?.draw(canvas)

    }

    fun configure(firstItemName: String, secondItemName: String) {
        firstItem?.text = firstItemName
        secondItem?.text = secondItemName
    }
}