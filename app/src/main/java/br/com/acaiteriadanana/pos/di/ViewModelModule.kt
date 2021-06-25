package br.com.acaiteriadanana.pos.di

import br.com.acaiteriadanana.pos.presentation.viewmodel.ProductManagerViewModel
import br.com.acaiteriadanana.pos.presentation.viewmodel.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {

    val modules = module {
        viewModel { ProductViewModel(get()) }
        viewModel { ProductManagerViewModel(get()) }
    }

}