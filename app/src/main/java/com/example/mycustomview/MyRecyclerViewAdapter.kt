package com.example.mycustomview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    val context: Context,
    val list1: List<String>,
    val list2: List<String>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val item = MyItemLayout(parent.context)
        return Holder(item)
    }

    override fun getItemCount(): Int {
        return list1.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = holder as Holder
        item.item?.configure(list1[position], list2[position])
    }
}

private class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var item: MyItemLayout? = null

    init {
        if (itemView is MyItemLayout) {
            item = itemView
        }
    }
}