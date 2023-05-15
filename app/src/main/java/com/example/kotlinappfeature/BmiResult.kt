package com.example.kotlinappfeature

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class BmiResult : AppCompatActivity() {

    lateinit var tvHeading: TextView
    lateinit var tvResult: TextView
    lateinit var tvDescription: TextView
    lateinit var layout: RelativeLayout
    var bmi: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_result)

          tvHeading = findViewById<TextView>(R.id.tv_heading_id)
          tvResult = findViewById<TextView>(R.id.tv_result_id)
          tvDescription = findViewById<TextView>(R.id.tv_description)
          layout = findViewById<RelativeLayout>(R.id.bmi_result_bg)

          bmi = intent.getStringExtra("bmi")?.toDouble()!!

        if (bmi != null) {
            if (bmi >= 25.0){
                layout.setBackgroundColor(Color.parseColor("#ff0000"))
                tvHeading.text = "You are Underweighted"
                tvResult.text = "Your BMI is $bmi"
                tvDescription.text ="Tips: Do exercise regulerly to reduce weight"
            }
            if (bmi >= 18.5){
                layout.setBackgroundColor(Color.parseColor("#00ff00"))
                tvHeading.text = "You weight is Normal"
                tvResult.text = "Your BMI is $bmi"
                tvDescription.text ="Tips: Nothing to do! enjoy your life"
            }
            if (bmi<18.5) {
                layout.setBackgroundColor(Color.parseColor("#ff0000"))
                tvHeading.text = "You are underweight"
                tvResult.text = "Your BMI is $bmi"
                tvDescription.text ="Tips: Eat more food gain some weight"
            }

        }

        findViewById<Button>(R.id.btn_ca_id).setOnClickListener {
            finish()
        }
    }
}