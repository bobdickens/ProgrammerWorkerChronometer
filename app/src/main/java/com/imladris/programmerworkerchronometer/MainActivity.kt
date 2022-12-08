package com.imladris.programmerworkerchronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.view.isInvisible
import com.imladris.programmerworkerchronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var timer: CountDownTimer? = null
    private var timerRelax: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            bStart.setOnClickListener{
                startCountDownTimer(3600000)
            }
        }
    }

    private fun startCountDownTimer(timeMillis: Long){
        binding.textrelax.visibility = View.INVISIBLE

        timer?.cancel()

       timer = object: CountDownTimer(timeMillis,1){
           override fun onTick(timeM: Long) {
               var timeMin = timeM/60000
               binding.tvTimer.text = timeMin.toString()
           }

           override fun onFinish() {
               binding.textrelax.visibility = View.VISIBLE
               binding.tvTimer.text = "Finish"

               timerRelax = object: CountDownTimer(300000,1){
                   override fun onTick(timeM: Long) {
                       var timeMin = timeM/1000
                       binding.textrelax.text = timeMin.toString()
                   }

                   override fun onFinish() {
                       binding.textrelax.text = "Finish"



                   }

               }.start()

           }

       }.start()
    }


}