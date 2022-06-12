package com.talhafaki.fuud.data

/**
 * Created by talhafaki on 12.06.2022.
 */

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}