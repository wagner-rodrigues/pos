package br.com.acaiteriadanana.pos.domain

import br.com.acaiteriadanana.pos.data.product.ProductTypeEnum
import br.com.acaiteriadanana.pos.data.product.ProductTypeEnum.values

object ProductTypeMapper {

    fun from(type: ProductTypeEnum) = values().find { it.ordinal == type.ordinal }?.description

}
