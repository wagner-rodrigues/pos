package br.com.acaiteriadanana.pos.common

sealed class ResultState<out R> {
    data class Success<out T>(val data: T?): ResultState<T>()
    data class Error(
        val exception: Throwable
    ): ResultState<Nothing>()
    object Loading: ResultState<Nothing>()
}