package com.example.kotlinappfeature

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExternalIcon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_icon)

        val profileName= intent.getStringExtra("key")
        println(profileName)
        findViewById<Button>(R.id.btn_intent).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.jakariya.info/")))
        }

        findViewById<Button>(R.id.btn_call_me).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("tel:+8801762940480")))
        }

        findViewById<Button>(R.id.btn_ping_me).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("smsto:+8801762940480")))
       }
    }
}