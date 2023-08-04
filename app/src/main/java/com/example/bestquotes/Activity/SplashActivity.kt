package com.example.bestquotes.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.bestquotes.R
import com.example.bestquotes.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}