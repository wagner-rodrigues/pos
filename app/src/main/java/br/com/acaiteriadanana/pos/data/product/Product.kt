package br.com.acaiteriadanana.pos.data.product

data class Product(
    val id: Long,
    val name: String,
    val type: ProductTypeEnum,
    val image: ByteArray,
    val price: Long? = 0L
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false
        if (type != other.type) return false
        if (!image.contentEquals(other.image)) return false
        if (price != other.price) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + (price?.hashCode() ?: 0)
        return result
    }
}
