package com.example.animelistapptest.data.utils

sealed class ResponseMapper<T>(
    val data: T? = null, val message: String? = null
) {
    class Success<T>(data: T?) : ResponseMapper<T>(data)
    class Loading<T>(data: T? = null) : ResponseMapper<T>(data)
    class Error<T>(message: String, data: T? = null) : ResponseMapper<T>(data, message)
}