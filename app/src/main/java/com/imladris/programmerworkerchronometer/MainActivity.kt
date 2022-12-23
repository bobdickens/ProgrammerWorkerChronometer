package com.imladris.programmerworkerchronometer

import android.content.Intent
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
            settingButton.setOnClickListener { openSettingsActivity() }
        }


        binding.apply {
            bStart.setOnClickListener{
                startCountDownTimer(3600000)
            }
        }
        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
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
    private fun openSettingsActivity(){
        val intent = Intent(this, SettingActivity::class.java)
        startActivity(intent)

        
    }


}