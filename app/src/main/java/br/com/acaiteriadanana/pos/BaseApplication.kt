package br.com.acaiteriadanana.pos

import android.app.Application
import br.com.acaiteriadanana.pos.di.RepositoryModule
import br.com.acaiteriadanana.pos.di.RetrofitModule
import br.com.acaiteriadanana.pos.di.ServicesModule
import br.com.acaiteriadanana.pos.di.UseCaseModule
import br.com.acaiteriadanana.pos.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin() {
            // declare used Android context
            androidContext(this@BaseApplication)
            printLogger()
            // declare modules
            modules(
                listOf(
                    ServicesModule.modules,
                    RetrofitModule.modules,
                    RepositoryModule.modules,
                    ViewModelModule.modules,
                    UseCaseModule.modules
                )
            )
        }
    }

}