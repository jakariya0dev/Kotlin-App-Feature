package com.example.kotlinappfeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CounterApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_app)

        val tv: TextView = findViewById(R.id.tv_counter)
        var num = 0;

        findViewById<FloatingActionButton>(R.id.btn_count_id).setOnClickListener {
            num++
            tv.text = num.toString();
            Toast.makeText(this, "x", Toast.LENGTH_SHORT).show()
        }
        findViewById<FloatingActionButton>(R.id.btn_count_id).setOnLongClickListener {
            num = -1
            Toast.makeText(this, "y", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener false
        }
    }
}