package br.com.acaiteriadanana.pos.datasource

import br.com.acaiteriadanana.pos.service.ProductService

class ProductRepository(private val service: ProductService) {

    suspend fun fetchAll() = service.fetchAll()

}