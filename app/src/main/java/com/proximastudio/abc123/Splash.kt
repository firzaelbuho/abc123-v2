package com.proximastudio.abc123

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.initialization.InitializationStatus
import kotlinx.android.synthetic.main.activity_main.*

class Splash : AppCompatActivity() {

    var progressStatus:Int = 0
    var handler:Handler = Handler()

    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 3100 // 1 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this){}

        setContentView(R.layout.activity_main)

        loadingBar()


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,Home::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }

    fun loadingBar(){
        Thread(Runnable {
            while (progressStatus < 100) {
                progressStatus += 1
                // Update the progress bar and display the
                //current value in the text view
                handler.post(Runnable {
                    progressBar.progress = progressStatus
                    //progressBar.setProgressTintList(ColorStateList.valueOf(Color.rgb(255,94,19)));

                })
                try {
                    // Sleep for 200 milliseconds.
                    Thread.sleep(30)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()
    }

    }

