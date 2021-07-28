package com.proximastudio.abc123

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.proximastudio.abc123.unity.UnityDataCenter
import kotlinx.android.synthetic.main.activity_menu_kuis.*
import kotlin.collections.ArrayList

class MenuKuis : AppCompatActivity() {

    lateinit var mAdView : AdView
    //val arrayShuffle = arrayOf
    val dataName2 = ArrayList<String>()
    val dataName  = ArrayList<String>()
    val dataImage = ArrayList<Int>()
    val dataAudio = ArrayList<Int>()
    var isTrue = false
    var audioSoal:Int = 0
    var currentIndex = -1
    var btnIndex = arrayOf(-1,-1,-1,-1)
    var temp = arrayOf(-1,-1,-1,-1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_kuis)

        //play bgm
        Database.bgm.start()
        Database.bgm.setVolume(0.1f,0.1f)

        showBannerAds()

        cekOption()
        setAllBtn(false)
        kuis()
    }

    fun kuis(){

        if(Database.tipe == 1){
            btnA.setBackgroundResource(R.drawable.item_red)
            btnB.setBackgroundResource(R.drawable.item_green)
            btnC.setBackgroundResource(R.drawable.item_blue)
            btnD.setBackgroundResource(R.drawable.item_yellow)
        }

        isTrue = false
        next.setBackgroundResource(R.drawable.ic_next_disabled)
        next.isEnabled = false

        //getIndex = (0..dataImage.size-1).random()
       //currentIndex = 0

        currentIndex = getRandom(dataName.size-1)
        btnIndex[0] = currentIndex
        btnIndex[1] = getRandom2(dataName.size-1)
        btnIndex[2] = getRandom2(dataName.size-1)
        btnIndex[3] = getRandom2(dataName.size-1)

        //shuffle
        shuffleBtn()


        //buat soal

        // play audio soal
        val mediaPlayer = MediaPlayer.create(this,audioSoal)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            val mp = MediaPlayer.create(this,dataAudio[currentIndex])
            mp.start()
            mp.setOnCompletionListener {
                // set button clickable
                setAllBtn(true)
            }
        }



        if(Database.tipe == 1){
            soal.text ="Yang manakah ${Database.option} ${dataName2[currentIndex]} ?"
            btnA.text = dataName[btnIndex[0]]
            btnB.text = dataName[btnIndex[1]]
            btnC.text = dataName[btnIndex[2]]
            btnD.text = dataName[btnIndex[3]]

        }else{
            soal.text ="Yang manakah ${Database.option} ${dataName[currentIndex]} ?"
            btnA.setBackgroundResource(dataImage[btnIndex[0]])
            btnB.setBackgroundResource(dataImage[btnIndex[1]])
            btnC.setBackgroundResource(dataImage[btnIndex[2]])
            btnD.setBackgroundResource(dataImage[btnIndex[3]])
        }


        //onClick Option

        btnA.setOnClickListener {
            checkAnswer(dataName[btnIndex[0]],dataName[currentIndex],btnA)
        }
        btnB.setOnClickListener {
            checkAnswer(dataName[btnIndex[1]],dataName[currentIndex],btnB)
        }
        btnC.setOnClickListener {
            checkAnswer(dataName[btnIndex[2]],dataName[currentIndex],btnC)
        }
        btnD.setOnClickListener {
            checkAnswer(dataName[btnIndex[3]],dataName[currentIndex],btnD)
        }
        next.setOnClickListener {
            Database.playSound(R.raw.klik,this)
            for(i in 0..3){
                btnIndex[i] = -1
            }
            //currentIndex++
            kuis()

        }


    }

    fun getRandom(sizelimit:Int):Int{
        val x = (0..sizelimit).random()

        if(x!=currentIndex){
            return x
        }else{
            return getRandom(sizelimit)
        }
    }
    fun getRandom2(sizelimit:Int):Int{
        val x = (0..sizelimit).random()

        if(x!=btnIndex[0] && x!=btnIndex[1] && x!=btnIndex[2] && x!=btnIndex[3]){
            return x
        }else{
            return getRandom2(sizelimit)
        }
    }
    fun getRandom3():Int{
        val x = (0..3).random()
        val y = temp[x]

        if(y!=btnIndex[0] && y!=btnIndex[1] && y!=btnIndex[2] && y!=btnIndex[3]){
            return y
        }else{
            return getRandom3()
        }
    }
    fun checkAnswer(answer:String, option:String,btn:Button){

        if(Database.tipe==1){
            btn.text = ""
        }

        if(answer==option){
            Database.playSoundHalf(R.raw.benar,this)
            isTrue = true
            setAllBtn(false)
            next.isEnabled = true
            btn.setBackgroundResource(R.drawable.bg_benar)
            next.setBackgroundResource(R.drawable.ic_next)

        }
        else{
            //play wrong sfx
            btn.setBackgroundResource(R.drawable.bg_salah)
            Database.playSoundHalf(R.raw.salah,this)
        }
    }



    fun cekOption(){
        when(Database.option){
            "angka"-> {
                for (i in 0 until Database.angka.size) {
                    dataName.add(Database.angka[i])
                    dataAudio.add(Database.angkaAudio[i])
                    dataName2.add(Database.angkaText[i])
                    audioSoal = R.raw.whick_angka
                }
            }
            "huruf"->{
                for (i in 0 until Database.huruf.size) {
                    dataName.add(Database.huruf[i])
                    dataAudio.add(Database.hurufAudio[i])
                    dataName2.add(" ... ")
                    audioSoal = R.raw.which_huruf
                }
            }
            "warna"->{
                for (i in 0 until Database.warna.size) {
                    dataName.add(Database.warna[i])
                    dataAudio.add(Database.warnaAudio[i])
                    dataImage.add(Database.warnaImage[i])
                    audioSoal = R.raw.which_warna
                }
            }
            "hewan"->{
                for (i in 0 until Database.hewan.size) {
                    dataName.add(Database.hewan[i])
                    dataAudio.add(Database.hewanAudio[i])
                    dataImage.add(Database.hewanImage[i])
                    audioSoal = R.raw.which_hewan
                }
            }
            "buah"->{
                for (i in 0 until Database.buah.size) {
                    dataName.add(Database.buah[i])
                    dataAudio.add(Database.buahAudio[i])
                    dataImage.add(Database.buahImage[i])
                    audioSoal = R.raw.which_buah
                }
            }
        }
    }



    fun shuffleBtn(){

        temp[0] = btnIndex[0]
        temp[1] = btnIndex[1]
        temp[2] = btnIndex[2]
        temp[3] = btnIndex[3]

        btnIndex[0] = -1
        btnIndex[1] = -1
        btnIndex[2] = -1
        btnIndex[3] = -1

        btnIndex[0] = getRandom3()
        btnIndex[1] = getRandom3()
        btnIndex[2] = getRandom3()
        btnIndex[3] = getRandom3()

    }

    fun setAllBtn(condition : Boolean){
        if(condition){
            btnA.isEnabled = true
            btnB.isEnabled = true
            btnC.isEnabled = true
            btnD.isEnabled = true
        }else{
            btnA.isEnabled = false
            btnB.isEnabled = false
            btnC.isEnabled = false
            btnD.isEnabled = false
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
        val layout = findViewById<LinearLayout>(R.id.banner_container_menu_kuis)
        UnityDataCenter.showBanner(this, layout)
    }



}


