package br.com.acaiteriadanana.pos.presentation.view.product

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.acaiteriadanana.pos.R
import br.com.acaiteriadanana.pos.databinding.ProductActivityBinding

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ProductActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureToolbar()
    }

    private fun configureToolbar() {
        binding.inToolbar.mtbToolbar.apply {
            title = getString(R.string.manage_products)
        }
    }
}