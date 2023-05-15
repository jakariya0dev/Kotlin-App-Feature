package com.example.kotlinappfeature

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AppBMI : AppCompatActivity() {

    lateinit var btnMale: LinearLayout
    lateinit var btnFemale: LinearLayout
    lateinit var seekBar: SeekBar
    lateinit var tvHeight: TextView
    lateinit var tvWeight: TextView
    lateinit var tvAge: TextView
    lateinit var btnWeightPlus: FloatingActionButton
    lateinit var btnWeightMinus: FloatingActionButton
    lateinit var btnAgePlus: FloatingActionButton
    lateinit var btnAgeMinus: FloatingActionButton
    var age = 1; var weight = 1; var height = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bmi)

         btnMale = findViewById<LinearLayout>(R.id.btn_male_id)
         btnFemale = findViewById<LinearLayout>(R.id.btn_female_id)
         seekBar = findViewById<SeekBar>(R.id.seekbar)
         tvHeight = findViewById<TextView>(R.id.tv_height)
         tvWeight = findViewById<TextView>(R.id.tv_weight)
         tvAge = findViewById<TextView>(R.id.tv_age)
         btnWeightPlus = findViewById<FloatingActionButton>(R.id.plus_btn_weight)
         btnWeightMinus = findViewById<FloatingActionButton>(R.id.minus_btn_weight)
         btnAgePlus = findViewById<FloatingActionButton>(R.id.plus_btn_age)
         btnAgeMinus = findViewById<FloatingActionButton>(R.id.minus_btn_age)

        tvAge.text = age.toString()
        tvWeight.text = weight.toString()


        seekBar?.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
//                Toast.makeText(applicationContext, p1.toString(), Toast.LENGTH_SHORT).show()
                height = p1
                tvHeight.text = height.toString()+" cm"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {


            }

        })

        btnMale.setOnClickListener {
            btnMale.setBackgroundColor(Color.parseColor("#FF640136"))
            btnFemale.setBackgroundColor(Color.parseColor("#880E4F"))

        }

        btnFemale.setOnClickListener {
            btnFemale.setBackgroundColor(Color.parseColor("#FF640136"))
            btnMale.setBackgroundColor(Color.parseColor("#880E4F"))

        }

        btnAgePlus.setOnClickListener {
            age++
            tvAge.text = age.toString()
        }

        btnAgeMinus.setOnClickListener {
            if (age>1){
                age--
                tvAge.text = age.toString()
            }
        }

        btnWeightPlus.setOnClickListener {
            weight++
            tvWeight.text = weight.toString()
        }

        btnWeightMinus.setOnClickListener {
            if (weight>1){
                weight--
                tvWeight.text = weight.toString()
            }
        }

        findViewById<LinearLayout>(R.id.btn_calculate).setOnClickListener {
            var bmi: Double = weight / Math.pow((height/100).toDouble(), 2.toDouble())
            Toast.makeText(this, bmi.toString(), Toast.LENGTH_SHORT).show()

            val intent = Intent(this, BmiResult::class.java)
            intent.putExtra("bmi", bmi.toString())
            startActivity(intent)
            Log.d("hello", bmi.toString())

        }
    }
}