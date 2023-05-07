package com.example.kotlinappfeature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class LoadImageFromUrl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_image_from_url)

        val iv4Picasso = findViewById<ImageView>(R.id.iv_picasso_id)
        val iv4Glide = findViewById<ImageView>(R.id.iv_glide_id)

        Picasso.get().load("https://images.unsplash.com/photo-1610441995419-a673724a8224?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YW5ncnklMjBnaXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60").into(iv4Picasso)

        Glide.with(this).load("https://images.pexels.com/photos/206481/pexels-photo-206481.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1").into(iv4Glide)
    }
}