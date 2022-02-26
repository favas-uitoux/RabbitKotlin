package com.project.rabbitkotlin.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import com.project.rabbitkotlin.R
import maes.tech.intentanim.CustomIntent.customType


class SplashActivity : AppCompatActivity() {

    private val MY_PERMISSIONS_REQUEST_CODE = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({ gotoNextScreen() }, 3000)



    }







   private fun gotoNextScreen()
    {
        startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        customType(this@SplashActivity, "fadein-to-fadeout")
       finish()

   }




}


