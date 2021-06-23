package br.com.acaiteriadanana.pos.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.acaiteriadanana.pos.common.ResultState
import br.com.acaiteriadanana.pos.common.ResultState.Error
import br.com.acaiteriadanana.pos.common.ResultState.Success
import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.domain.useCase.FetchProductsUseCase
import kotlinx.coroutines.launch

class ProductViewModel constructor(private val fetchProductsUseCase: FetchProductsUseCase): BaseViewModel() {

    private val _productsState = MutableLiveData<ResultState<List<Product>>>()
    val productsState: LiveData<ResultState<List<Product>>> = _productsState

    fun fetchProducts() = try {
        getCoroutinesScope().launch {
            fetchProductsUseCase.run().also {
                when {
                    it.isEmpty() -> _productsState.postValue(Success(null))
                    else -> _productsState.postValue(Success(it))
                }
            }
        }
    } catch (e: Exception) {
        _productsState.postValue(Error(e))
    }

}