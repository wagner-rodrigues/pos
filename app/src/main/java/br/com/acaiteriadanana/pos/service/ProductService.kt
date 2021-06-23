package br.com.acaiteriadanana.pos.service

import br.com.acaiteriadanana.pos.data.product.Product
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ProductService {
    @GET("products")
    suspend fun fetchAll(): List<Product>

    @GET("product/{id}")
    suspend fun fetchById(@Query("id") id: Long)

    @POST("product/")
    suspend fun add(@Body product: Product): Product

    @PUT("product/{id}")
    suspend fun saveById(@Body product: Product, @Query("id") id: Long)

    @DELETE("product/{id}")
    suspend fun deleteById(@Query("id") id: Long)
}
