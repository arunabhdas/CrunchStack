package com.arunabhdas.test.service

import com.arunabhdas.test.model.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi  {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}

object RetrofitHelper {
    val baseUrl = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): Retrofit {
       return Retrofit.Builder().baseUrl(baseUrl)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }
}