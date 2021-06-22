package br.com.acaiteriadanana.pos.presentation.view.main

import android.content.Intent
import android.os.Bundle
import br.com.acaiteriadanana.pos.presentation.view.BaseActivity

class SplashScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(5000)
        val mainActivity = Intent(this, MainActivity::class.java)
        startActivity(mainActivity)
        finishAfterTransition()
    }
}