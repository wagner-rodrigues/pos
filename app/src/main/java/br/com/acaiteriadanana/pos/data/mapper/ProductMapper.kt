package br.com.acaiteriadanana.pos.data.mapper

import br.com.acaiteriadanana.pos.data.product.Product
import br.com.acaiteriadanana.pos.domain.Product as ProductDomain

object ProductMapper {

    fun toDomain(products: List<Product>) =
        products.map { ProductDomain(it.id, it.name, it.type, it.image, it.price) }

    fun toDomain(product: Product) =
        ProductDomain(product.id, product.name, product.type, product.image, product.price)

}