package br.com.acaiteriadanana.pos.di

import br.com.acaiteriadanana.pos.datasource.ProductRepository
import org.koin.dsl.module

object RepositoryModule {

    val modules = module {
        single { ProductRepository(get()) }
    }

}