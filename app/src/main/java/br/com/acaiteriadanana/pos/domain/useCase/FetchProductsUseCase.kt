package br.com.acaiteriadanana.pos.domain.useCase

import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.service.ProductService

class FetchProductsUseCase(private val productService: ProductService): BaseUseCase<List<Product>>() {

    override fun executeUseCase(): List<Product> {
        return productService.fetchProducts()
    }

}
