package com.example.ithome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import java.util.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        var timer = Timer()
        class MyTimerTask() : TimerTask() {
            override fun run() {
                val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        var timeTask = MyTimerTask()
        timer.schedule(timeTask, 2000)
    }
}