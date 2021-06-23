package br.com.acaiteriadanana.pos.data.mapper

import br.com.acaiteriadanana.pos.data.product.Product
import br.com.acaiteriadanana.pos.domain.Product as ProductDomain

object ProductMapper {
    fun toDomain(products: List<Product>): List<ProductDomain> {
        return products.map { ProductDomain(it.id, it.name, it.type, it.image, it.price) }
    }

}
