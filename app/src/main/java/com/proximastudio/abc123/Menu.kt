package com.proximastudio.abc123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.proximastudio.abc123.unity.UnityDataCenter
import kotlinx.android.synthetic.main.activity_menu.*


class Menu : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //play bgm
        Database.bgm.start()
        Database.bgm.setVolume(0.1f,0.1f)

        showBannerAds()


        text_title.text = "Silahkan pilih menu ${Database.mode}"

        if(Database.mode == "belajar"){
            Database.playSound(R.raw.menu_belajar,this)
        }else{
            Database.playSound(R.raw.menu_kuis,this)
        }

        menu_warna.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            Database.tipe = 2
            Database.option = "warna"
            moveToMenu()
        }

        menu_huruf.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            Database.tipe = 1
            Database.option = "huruf"
            moveToMenu()
        }

        menu_angka.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            Database.tipe = 1
            Database.option = "angka"
            moveToMenu()
        }
        menu_hewan.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            Database.tipe = 2
            Database.option = "hewan"
            moveToMenu()
        }
        menu_buah.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            Database.tipe = 2
            Database.option = "buah"
            moveToMenu()
        }

        backBtn.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            startActivity(Intent(this@Menu,Home::class.java))

        }



    }
    fun moveToMenu(){
        if(Database.mode=="belajar"){
            startActivity(Intent(this@Menu,MenuBelajar::class.java))
        }else{
            startActivity(Intent(this@Menu,MenuKuis::class.java))
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

    fun showBannerAds(){
        UnityDataCenter.initializeAds(this)
        val layout = findViewById<LinearLayout>(R.id.banner_container_menu)
        UnityDataCenter.showBanner(this, layout)
    }
}
