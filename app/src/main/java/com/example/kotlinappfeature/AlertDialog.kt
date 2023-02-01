package com.example.kotlinappfeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AlertDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        
        findViewById<Button>(R.id.btn_show_ad_id).setOnClickListener {


//           var builder = AlertDialog.Builder(this)
//
        }
    }
}