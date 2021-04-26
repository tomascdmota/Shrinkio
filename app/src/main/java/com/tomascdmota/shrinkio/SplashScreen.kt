package com.tomascdmota.shrinkio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.tomascdmota.shrinkio.Login.LoginActivity

class SplashScreen : AppCompatActivity() {

    /*This loads the splash screen for 3 seconds*/

        private var mDelayHandler : Handler? = null
        private val SPLASH_DELAY : Long = 3000 // This is taken is milliseconds so 3000ms = 3 seconds

        internal val mRunnalbe: Runnable = Runnable {
            if(!isFinishing) {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnalbe, SPLASH_DELAY)
    }


    public override fun onStart() {
        super.onStart()
        //Check if the user is already Logged in

    }

    public override fun onDestroy(){
        if(mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnalbe)
        }
        super.onDestroy()
    }
}