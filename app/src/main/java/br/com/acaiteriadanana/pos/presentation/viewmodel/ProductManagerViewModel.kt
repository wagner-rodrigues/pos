package br.com.acaiteriadanana.pos.presentation.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.acaiteriadanana.pos.common.ResultState
import br.com.acaiteriadanana.pos.common.ResultState.*
import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.domain.useCase.FetchProductUseCase
import kotlinx.coroutines.launch

class ProductManagerViewModel(val fetchProductUseCase: FetchProductUseCase) : BaseViewModel() {

    private val _productData = MutableLiveData<ResultState<Product>>()
    val productData: LiveData<ResultState<Product>> = _productData

    private val _image = MutableLiveData<Bitmap>()
    val image: LiveData<Bitmap> = _image

    fun fetchProduct(productId: Long) {
        getCoroutinesScope().launch {
            try {
                fetchProductUseCase.run().also {
                    _productData.postValue(Success(it))
                }
            } catch(e: Exception) {
                _productData.postValue(Error(e))
            }
        }
    }
    // TODO: Implement the ViewModel
}