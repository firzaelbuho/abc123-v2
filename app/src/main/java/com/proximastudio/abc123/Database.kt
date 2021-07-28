package com.proximastudio.abc123

import android.content.Context
import android.media.MediaPlayer

class Database {

    companion object {

        lateinit var bgm:MediaPlayer

        //selected
        var selectedText = ""
        var selectedName = "def"
        var selectedImg = 0
        var selectedAudio = 0


        //optien : angka, huruf, warna,hewan,buah
        var option = "defaultOption"

        //tipe = 1 or 2
        var tipe = 0

        //mode
        var mode = "defaultMode"

        //Datasets


        val huruf = arrayOf(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"
        )

        val hurufAudio = arrayOf(
            R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e,
            R.raw.f, R.raw.g, R.raw.h, R.raw.i, R.raw.j,
            R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.o,
            R.raw.p, R.raw.q, R.raw.r, R.raw.s, R.raw.t,
            R.raw.u, R.raw.v, R.raw.w, R.raw.x, R.raw.y,
            R.raw.z
        )


        val angka = arrayOf(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        )

        val angkaAudio = arrayOf(
            R.raw.satu, R.raw.dua, R.raw.tiga, R.raw.empat, R.raw.lima,
            R.raw.enam, R.raw.tujuh, R.raw.delapan, R.raw.sembilan, R.raw.sepuluh
        )
        val angkaText = arrayOf(
            "satu",
            "dua",
            "tiga",
            "empat",
            "lima",
            "enam",
            "tujuh",
            "delapam",
            "sembilan",
            "sepuluh"
        )

        val warna = arrayOf(
            "merah", "biru", "hijau", "ungu", "putih", "oren", "pink", "hitam", "kuning", "cokelat"
        )
        val warnaImage = arrayOf(
            R.drawable.merah,
            R.drawable.biru,
            R.drawable.hijau,
            R.drawable.ungu,
            R.drawable.putih,
            R.drawable.oren,
            R.drawable.pink,
            R.drawable.hitam,
            R.drawable.kuning,
            R.drawable.cokelat
        )
        val warnaAudio = arrayOf(
            R.raw.merah, R.raw.biru, R.raw.hijau, R.raw.ungu, R.raw.putih,
            R.raw.oren, R.raw.pink, R.raw.hitam, R.raw.kuning, R.raw.cokelat
        )

        val hewan = arrayOf(
            "gajah", "harimau", "kucing", "anjing", "sapi",
            "kambing", "ayam", "singa", "kuda", "badak",
            "kelinci", "kupu-kupu", "laba-laba", "bebek", "jerapah",
            "buaya","ular","angsa","kudanil","ikan",
            "lumba-lumba","burung","semut","nyamuk","udang"
        )
        val hewanAudio = arrayOf(
            R.raw.gajah, R.raw.harimau, R.raw.kucing, R.raw.anjing, R.raw.sapi,
            R.raw.kambing, R.raw.ayam, R.raw.singa, R.raw.kuda, R.raw.badak,
            R.raw.kelinci, R.raw.kupu, R.raw.laba, R.raw.bebek, R.raw.jerapah,
            R.raw.buaya, R.raw.ular, R.raw.angsa, R.raw.kudanil, R.raw.ikan,
            R.raw.lumba, R.raw.burung, R.raw.semut, R.raw.nyamuk, R.raw.udang

        )
        val hewanImage = arrayOf(
            R.drawable.gajah, R.drawable.harimau, R.drawable.kucing, R.drawable.anjing, R.drawable.sapi,
            R.drawable.kambing, R.drawable.ayam, R.drawable.singa, R.drawable.kuda, R.drawable.badak,
            R.drawable.kelinci, R.drawable.kupu, R.drawable.laba, R.drawable.bebek, R.drawable.jerapah,
            R.drawable.buaya, R.drawable.ular, R.drawable.angsa, R.drawable.kudanil, R.drawable.ikan,
            R.drawable.lumba, R.drawable.burung, R.drawable.semut, R.drawable.nyamuk, R.drawable.udang
        )

        val buah = arrayOf(
            "apel", "anggur", "pisang", "melon", "semangka",
            "stroberi", "manggis", "durian", "rambutan", "jambu",
            "alpukat", "pepaya", "jeruk", "mangga", "nanas",
            "salak","sirsak","kelapa","duku","tomat"
        )
        val buahAudio = arrayOf(
            R.raw.apel, R.raw.anggur, R.raw.pisang, R.raw.melon, R.raw.semangka,
            R.raw.stroberi, R.raw.manggis, R.raw.durian, R.raw.rambutan, R.raw.jambu,
            R.raw.alpukat, R.raw.pepaya, R.raw.jeruk, R.raw.mangga, R.raw.nanas,
            R.raw.salak,R.raw.sirsak,R.raw.kelapa,R.raw.duku,R.raw.tomat
        )
        val buahImage = arrayOf(
            R.drawable.apel, R.drawable.anggur, R.drawable.pisang, R.drawable.melon, R.drawable.semangka,
            R.drawable.stroberi, R.drawable.manggis, R.drawable.durian, R.drawable.rambutan, R.drawable.jambu,
            R.drawable.alpukat, R.drawable.pepaya, R.drawable.jeruk, R.drawable.mangga, R.drawable.nanas,
            R.drawable.salak, R.drawable.sirsak, R.drawable.kelapa, R.drawable.duku, R.drawable.tomat
        )


        var isBgmPlayed = false


        fun playSound(source: Int, context: Context) {
            val mediaPlayer = MediaPlayer.create(context, source)
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                mediaPlayer.stop();
                mediaPlayer.release();
            }


        }

        fun playSoundHalf(source: Int, context: Context) {
            val mediaPlayer = MediaPlayer.create(context, source)
            mediaPlayer.start()
            mediaPlayer.setVolume(0.5f, 0.5f)
            mediaPlayer.setOnCompletionListener {
                mediaPlayer.stop();
                mediaPlayer.release();
            }


        }
    }

}