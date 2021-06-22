package br.com.acaiteriadanana.pos.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.domain.useCase.FetchProductsUseCase

class ProductViewModel constructor(private val fetchProductsUseCase: FetchProductsUseCase): ViewModel() {

    private val noProducts = MutableLiveData<Boolean>()
    val products = MutableLiveData<List<Product>>()

    fun fetchProducts() = try {
        fetchProductsUseCase.run().also {
            when {
                it.isEmpty() -> noProducts.postValue(true)
            }
            products.postValue(it)
        }
    } catch (e: Exception) {

    }

}