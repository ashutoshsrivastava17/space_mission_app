package com.backbase.assignment.repository

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 07:10 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String?) : Result<Nothing>()
    object LoadingStart : Result<Nothing>()
    object LoadingStop : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$message]"
            is LoadingStart -> "LoadingStart"
            is LoadingStop -> "LoadingStop"
        }
    }

    val extractData: T?
        get() = when (this) {
            is Success -> data
            is Error -> null
            is LoadingStart -> null
            is LoadingStop -> null
        }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null


