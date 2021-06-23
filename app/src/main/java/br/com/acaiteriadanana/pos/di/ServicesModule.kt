package br.com.acaiteriadanana.pos.di

import br.com.acaiteriadanana.pos.service.ProductService
import org.koin.dsl.module
import retrofit2.Retrofit

object ServicesModule {
    val modules = module {
        factory { provideProductService(get()) }
    }

    fun provideProductService(retrofit: Retrofit): ProductService =
        retrofit.create(ProductService::class.java)
}