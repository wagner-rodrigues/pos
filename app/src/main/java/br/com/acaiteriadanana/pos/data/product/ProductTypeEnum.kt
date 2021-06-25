package br.com.acaiteriadanana.pos.data.product

enum class ProductTypeEnum(val description: String) {
    FOOD("Comida"),
    DRINK("Bebida"),
    COMBO("Combo");

    override fun toString(): String {
        return description
    }
}
