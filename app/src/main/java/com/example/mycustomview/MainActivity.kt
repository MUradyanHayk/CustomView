package com.example.mycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list1 = listOf("Hayk", "Hovo", "Sofya", "Harut", "Mama", "Tati")
        val list2 = listOf("24", "15", "12", "10", "44", "75")

//
//        val layout = MyItemLayout(this)
//        val params = FrameLayout.LayoutParams(
//            FrameLayout.LayoutParams.MATCH_PARENT,
//            FrameLayout.LayoutParams.WRAP_CONTENT
//        )
//        params.gravity = Gravity.CENTER
//        layout.layoutParams = params
//        layout.configure("First Item", "Second Item")
//        setContentView(layout)

        val recycleListView: RecyclerView = findViewById(R.id.my_recycler_view)
        val adapter = MyRecyclerViewAdapter(this, list1, list2)
        recycleListView.adapter = adapter
        recycleListView.layoutManager = LinearLayoutManager(this)
    }
}
