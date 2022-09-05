package com.example.note.core

import com.example.note.data.model.Note

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
}
