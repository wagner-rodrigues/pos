package br.com.acaiteriadanana.pos.presentation.view.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.com.acaiteriadanana.pos.databinding.ProductFragmentBinding
import br.com.acaiteriadanana.pos.presentation.view.BaseFragment
import br.com.acaiteriadanana.pos.presentation.viewmodel.ProductViewModel

class ProductFragment : BaseFragment() {

    private lateinit var binding: ProductFragmentBinding
    private val viewModel by viewModels<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureEvents()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun configureEvents() {
        viewModel.products.observe(viewLifecycleOwner, {
            when {
                it.isEmpty() -> showEmpty()
            }
        })
    }

    private fun showEmpty() {
        TODO("Not yet implemented")
    }
}