package com.proximastudio.abc123

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.proximastudio.abc123.unity.UnityAdsListener
import com.proximastudio.abc123.unity.UnityBannerListener
import com.proximastudio.abc123.unity.UnityDataCenter
import com.unity3d.ads.UnityAds
import com.unity3d.services.banners.BannerView
import com.unity3d.services.banners.UnityBannerSize
import kotlinx.android.synthetic.main.activity_home.*

@Suppress("DEPRECATION")
class Home : AppCompatActivity() {

    lateinit var mAdView : AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        showBannerAds()

        if(!Database.isBgmPlayed){
            Database.bgm = MediaPlayer.create(this,R.raw.bgm)
            Database.bgm.start()
            Database.bgm.setVolume(0.3f,0.3f)
            Database.bgm.isLooping = true
            Database.isBgmPlayed = true
        }else{
            Database.bgm.setVolume(0.3f,0.3f)
        }



        btnStart.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            startActivity(Intent(this@Home, Menu::class.java))
            Database.mode = "belajar"

        }
        btnKuis.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            startActivity(Intent(this@Home, Menu::class.java))
            Database.mode = "kuis"

        }
        about.setOnClickListener {
            startActivity(Intent(this@Home, About::class.java))
        }
    }

    override fun onPause() {
        super.onPause()
        Database.bgm.pause()
    }

    override fun onResume() {
        super.onResume()
        Database.bgm.start()
        Database.bgm.setVolume(0.3f,0.3f)
    }

    fun showBannerAds(){
        UnityDataCenter.initializeAds(this)
        val layout = findViewById<LinearLayout>(R.id.banner_container_home)
        UnityDataCenter.showBanner(this, layout)
    }



}
