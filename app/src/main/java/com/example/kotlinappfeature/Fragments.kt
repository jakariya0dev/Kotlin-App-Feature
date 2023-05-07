package com.example.kotlinappfeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        findViewById<Button>(R.id.btn_gm_one_id).setOnClickListener {
            addFragments(FragmentOne())
        }

        findViewById<Button>(R.id.btn_gm_two_id).setOnClickListener {
            addFragments(FragmentTwo())
        }
    }

    private fun addFragments(fragment: Fragment) {

        val fm = supportFragmentManager.beginTransaction()
        fm.replace(R.id.fragment_container, fragment)
        fm.commit()
    }


}