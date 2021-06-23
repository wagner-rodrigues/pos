package br.com.acaiteriadanana.pos.presentation.view.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.acaiteriadanana.pos.common.ResultState.Error
import br.com.acaiteriadanana.pos.common.ResultState.Loading
import br.com.acaiteriadanana.pos.common.ResultState.Success
import br.com.acaiteriadanana.pos.databinding.ProductFragmentBinding
import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.presentation.view.BaseFragment
import br.com.acaiteriadanana.pos.presentation.viewmodel.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductFragment : BaseFragment() {

    private lateinit var binding: ProductFragmentBinding
    private val productViewModel by viewModel<ProductViewModel>()

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
        productViewModel.fetchProducts()
    }

    private fun configureEvents() {
        productViewModel.productsState.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Error -> showError()
                is Loading -> showLoading()
                is Success -> {
                    result.data?.also { showSuccess(it) } ?:  showEmpty()
                }
            }
        })

        binding.fabNewProduct.setOnClickListener {
            findNavController().navigate()
        }
    }

    private fun showSuccess(products: List<Product>) {
        resetViewState()
        with(binding.inSuccess) {
            root.isVisible = true
            rvProductList.apply {
                adapter = ProductListAdapter(context, products)
                layoutManager = LinearLayoutManager(context)
            }
        }

    }

    private fun showLoading() {
        resetViewState()
        binding.inLoading.root.isVisible = true
    }

    private fun showError() {
        resetViewState()
        binding.inError.root.isVisible = true
    }

    private fun showEmpty() {
        resetViewState()
        binding.inEmpty.root.isVisible = true
    }

    private fun resetViewState() {
        with(binding) {
            inLoading.root.isVisible = false
            inSuccess.root.isVisible = false
            inSuccess.root.isVisible = false
            inSuccess.root.isVisible = false
        }
    }
}