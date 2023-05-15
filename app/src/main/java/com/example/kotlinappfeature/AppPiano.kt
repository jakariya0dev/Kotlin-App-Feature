package com.example.kotlinappfeature

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AppPiano : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_piano)

        var btnNoteOne = findViewById<Button>(R.id.note_one_btn_id)

        var mMediaPlayer: MediaPlayer? = null

        fun playSound() {
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.aa)
                mMediaPlayer!!.isLooping = true
                mMediaPlayer!!.start()
            } else mMediaPlayer!!.start()
        }




    }
}