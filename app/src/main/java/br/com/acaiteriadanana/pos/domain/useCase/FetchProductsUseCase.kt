package br.com.acaiteriadanana.pos.domain.useCase

import br.com.acaiteriadanana.pos.data.mapper.ProductMapper
import br.com.acaiteriadanana.pos.datasource.ProductRepository
import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.service.ProductService

class FetchProductsUseCase(private val productRepository: ProductRepository) :
    BaseUseCase<BaseUseCase.BaseParameters, List<Product>>() {

    override suspend fun execute(parameters: BaseParameters?) =
        ProductMapper.toDomain(productRepository.fetchAll())

}
