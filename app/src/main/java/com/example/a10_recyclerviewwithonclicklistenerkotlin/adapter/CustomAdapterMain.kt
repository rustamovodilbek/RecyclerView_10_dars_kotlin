package com.example.a10_recyclerviewwithonclicklistenerkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a10_recyclerviewwithonclicklistenerkotlin.R
import com.example.a10_recyclerviewwithonclicklistenerkotlin.activity.MainActivity
import com.example.a10_recyclerviewwithonclicklistenerkotlin.model.Member

class CustomAdapterMain(val activity: MainActivity, val members: List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_view, parent, false)
        return CustomViewHolderMain(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)
        if (holder is CustomViewHolderMain){
            holder.tv_name.setText(member.tv_name)
            holder.tv_tel_number.setText(member.tv_tel_number)

            holder.LineraLayout.setOnClickListener {
                activity.openItemDetails(member)
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }


    class CustomViewHolderMain(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name :TextView
        val tv_tel_number:TextView
        val LineraLayout:LinearLayout
        init {
            LineraLayout = view.findViewById(R.id.LineraLayout)
            tv_name = view.findViewById(R.id.tv_name)
            tv_tel_number = view.findViewById(R.id.tv_tel_number)
        }
    }

}
