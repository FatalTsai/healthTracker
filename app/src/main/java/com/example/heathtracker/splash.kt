package com.example.heathtracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val backgroundImage: ImageView = findViewById(R.id.imageView)
        val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeout)
        backgroundImage.startAnimation(sideAnimation)


        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1600) // delaying for 4 seconds...

    }
}