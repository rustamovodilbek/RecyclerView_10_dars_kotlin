package com.example.a10_recyclerviewwithonclicklistenerkotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a10_recyclerviewwithonclicklistenerkotlin.R
import com.example.a10_recyclerviewwithonclicklistenerkotlin.adapter.CustomAdapterMain
import com.example.a10_recyclerviewwithonclicklistenerkotlin.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapterMain(this, members)
        recyclerView_main.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..30 step 1){
            members.add(Member( "Odilbek $i", "+998 97 775 17 79"))
        }
        return members
    }

    fun initViews(){
        recyclerView_main.layoutManager = GridLayoutManager(this, 1)
    }

    fun openItemDetails(member: Member){
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }
}