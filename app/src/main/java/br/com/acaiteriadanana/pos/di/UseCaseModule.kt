package br.com.acaiteriadanana.pos.di

import br.com.acaiteriadanana.pos.domain.useCase.FetchProductsUseCase
import org.koin.dsl.module

object UseCaseModule {

    val modules = module {
        single { FetchProductsUseCase(get()) }
    }

}