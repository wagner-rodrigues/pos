package br.com.acaiteriadanana.pos.presentation.view.main

import android.content.Intent
import android.os.Bundle
import br.com.acaiteriadanana.pos.databinding.MainActivityBinding
import br.com.acaiteriadanana.pos.databinding.SplashScreenActivityBinding
import br.com.acaiteriadanana.pos.presentation.view.BaseActivity

class SplashScreenActivity : BaseActivity() {

    private lateinit var binding: SplashScreenActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread.sleep(2000)
        val mainActivity = Intent(this, MainActivity::class.java)
        startActivity(mainActivity)
        finishAfterTransition()
    }
}