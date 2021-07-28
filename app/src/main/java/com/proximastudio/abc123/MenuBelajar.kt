package com.proximastudio.abc123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_menu_belajar.*

class MenuBelajar : AppCompatActivity() {

    val list = ArrayList<DataItem>()
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_belajar)

        //play bgm
        Database.bgm.start()
        Database.bgm.setVolume(0.1f,0.1f)

        mRecyclerView.setHasFixedSize(true)

        addData()
        showRecyclerGrid()
    }



    private fun showRecyclerGrid() {
        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
        val gridAdapter = Adapter(list)
        mRecyclerView.adapter = gridAdapter
    }

    fun addData(){


       when(Database.option){

            "warna" -> {
                for (i in 0 until Database.warna.size){
                    list.add(DataItem(Database.warna[i],Database.warnaImage[i],Database.warnaAudio[i]))
                }
            }
            "angka" -> {
                for (i in 0 until Database.angka.size){
                    list.add(DataItem("${Database.angka[i]}",0,Database.angkaAudio[i],Database.angkaText[i]))
                }
            }

            "huruf" -> {
                for (i in 0 until Database.huruf.size){
                    list.add(DataItem(Database.huruf[i],0,Database.hurufAudio[i]))
                }
            }
            "hewan" -> {
                for (i in 0 until Database.hewan.size){
                    list.add(DataItem(Database.hewan[i],Database.hewanImage[i],Database.hewanAudio[i]))
                }
            }
            "buah"  ->{
                for (i in 0 until Database.buah.size){
                    list.add(DataItem(Database.buah[i],Database.buahImage[i],Database.buahAudio[i]))
                }
            }

//
//
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
