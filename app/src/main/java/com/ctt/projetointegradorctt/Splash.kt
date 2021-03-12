package com.ctt.projetointegradorctt
import android.content.Intent
import android.os.Bundle
import android.app.Activity
import android.os.Handler
import android.view.Menu


class Splash : Activity() {
    private val SPLASH_DISPLAY_LENGTH = 1000

    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.splash)

        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this@Splash, Menu::class.java)
            this@Splash.startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}