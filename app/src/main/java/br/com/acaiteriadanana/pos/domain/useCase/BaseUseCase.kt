package br.com.acaiteriadanana.pos.domain.useCase

import java.util.concurrent.CancellationException

abstract class BaseUseCase<P : BaseUseCase.BaseParameters, T : Any> {

    private var parameters: P? = null

    fun setParameters(parameters: P) {
        this.parameters = parameters
    }

    internal suspend fun run(): T {
        try {
            return execute(parameters)
        } catch (ce: CancellationException) {
            throw ce
        } catch (t: Throwable) {
            throw t
        }
    }

    abstract suspend fun execute(parameters: P? = null): T

    open class BaseParameters
}