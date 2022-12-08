package com.imladris.programmerworkerchronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imladris.programmerworkerchronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}