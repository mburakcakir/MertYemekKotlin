package com.mburcak.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.mburcak.R
import io.fabric.sdk.android.Fabric

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_splash_screen)

        Thread(Runnable {
            try {
                Thread.sleep(1000)
            } catch (e: Exception) {

            } finally {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }).start()
    }
}

