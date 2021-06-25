package br.com.acaiteriadanana.pos.domain.useCase

import br.com.acaiteriadanana.pos.data.mapper.ProductMapper.toDomain
import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.domain.useCase.FetchProductUseCase.Parameter
import br.com.acaiteriadanana.pos.service.ProductService

class FetchProductUseCase(private val productService: ProductService):
    BaseUseCase<Parameter, Product>() {

    data class Parameter(val id: Long): BaseParameters()

    override suspend fun execute(parameters: Parameter?) =
        toDomain(productService.fetchById(parameters!!.id))

}
