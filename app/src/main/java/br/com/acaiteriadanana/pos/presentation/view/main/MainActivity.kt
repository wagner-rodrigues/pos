package br.com.acaiteriadanana.pos.presentation.view.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import br.com.acaiteriadanana.pos.R
import br.com.acaiteriadanana.pos.databinding.MainActivityBinding
import br.com.acaiteriadanana.pos.presentation.view.BaseActivity
import br.com.acaiteriadanana.pos.presentation.view.product.ProductActivity
import br.com.acaiteriadanana.pos.presentation.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBar(binding.inToolbar.mtbToolbar)
        configureEvents()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onMenuItemSelected(featureId: Int, item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.mnManageMenu -> startActivity(Intent(this, MainActivity::class.java))
            R.id.mnManageProducts -> startActivity(Intent(this, ProductActivity::class.java))
            R.id.mnReport -> startActivity(Intent(this, MainActivity::class.java))
        }
        return true
    }

    private fun configureEvents() {

    }
}
