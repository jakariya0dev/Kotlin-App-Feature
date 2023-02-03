package com.example.kotlinappfeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // Generating Data
        val myList = ArrayList<DataClassForRecyclerView>()

        for (i in 1..50){
            myList.add(DataClassForRecyclerView("This is title $i", "This is sub title $i"))
        }

        // For RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_id)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = AdapterForRecyclerView(myList)
    }
}