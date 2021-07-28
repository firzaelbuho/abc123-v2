package com.proximastudio.abc123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*


class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        //play bgm
        Database.bgm.start()
        Database.bgm.setVolume(0.1f,0.1f)

        back.setOnClickListener {
            startActivity(Intent(this@About, Home::class.java))
        }


    }

    override fun onPause() {
        super.onPause()
        Database.bgm.pause()
    }

    override fun onResume() {
        super.onResume()
        Database.bgm.start()
        Database.bgm.setVolume(0.1f,0.1f)
    }
}
