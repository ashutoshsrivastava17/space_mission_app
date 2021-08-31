package assignment.leanix.repository

import com.backbase.assignment.repository.Result
import retrofit2.Response


/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 11:02 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
abstract class BaseAPIResponse {

    fun <T> safeApiCall(apiCall: () -> Response<T?>): Result<T> {
        return try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return@safeApiCall Result.Success(body)
                }
            }
            error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            error(e.message ?: e.toString())
        }
    }


    private fun <T> error(errorMessage: String): Result<T> =
        Result.Error(message = errorMessage)

}