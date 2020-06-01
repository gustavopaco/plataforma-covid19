package br.com.cotemig.covid19.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.cotemig.covid19.R

class SplashActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            goLoginActivity()

        }, 1000)

    }

    fun goLoginActivity() {
        var intent = Intent(this, NoticiasActivity::class.java)
        startActivity(intent)
        finish()
    }

}