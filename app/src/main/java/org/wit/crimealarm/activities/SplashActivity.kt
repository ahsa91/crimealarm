package org.wit.crimealarm.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import org.wit.crimealarm.R
import org.wit.crimealarm.main.MainApp

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //fullscreen mode for splashscreen
        //https://stackoverflow.com/questions/62835053/how-to-set-fullscreen-in-android-r
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        Handler().postDelayed(
            {
                // Launched PlacemarkListActivity initially
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish() // closes splash screen activity
            },
            2500
        ) // Here we pass the delay time in milliSeconds after which the splash activity will disappear.
    }
}