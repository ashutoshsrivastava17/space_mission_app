package com.backbase.assignment.repository

import assignment.leanix.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by Ashutosh Srivastava on 30-Aug-2021 9:30 PM.
 * Project : LeanIX Sample
 * Copyright (c) 2021  All rights reserved.
 */
object RetrofitFactory {

    private const val BASE_URL = "https://api.spacex.land/"

    private const val CONNECTION_TIMEOUT = 60
    private const val WRITE_TIMEOUT = 60
    private const val READ_TIMEOUT = 60

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .baseUrl(BASE_URL)
            .build()
    }

    private val converterFactory: Converter.Factory
        get() {
            return GsonConverterFactory.create()
        }

    private val okHttpClient: OkHttpClient
        get() {
            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder
                .addInterceptor(authenticationInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
            return okHttpClientBuilder.build()
        }

    private val httpLoggingInterceptor: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            return httpLoggingInterceptor
        }

    private val authenticationInterceptor: Interceptor
        get() {
            return object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original: Request = chain.request()
                    val originalHttpUrl = original.url
                    val url = originalHttpUrl.newBuilder()
                        .build()
                    val requestBuilder: Request.Builder = original.newBuilder()
                        .url(url)
                    val request: Request = requestBuilder.build()
                    return chain.proceed(request)
                }
            }
        }
}