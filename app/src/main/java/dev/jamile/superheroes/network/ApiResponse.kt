package dev.jamile.superheroes.network

sealed class ApiResponse<out T> {
    class Loading(val isLoading: Boolean) : ApiResponse<Boolean>()
    class Success<out T>(val data: T) : ApiResponse<T>()
    class Failure(val throwable: Throwable) : ApiResponse<Nothing>()
}