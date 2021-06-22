package br.com.acaiteriadanana.pos.domain.useCase

abstract class BaseUseCase<T> {

    internal fun run(): T {
        return executeUseCase()
    }

    abstract fun executeUseCase(): T

}