package com.arunabhdas.test.repository

import com.arunabhdas.test.model.User
import com.arunabhdas.test.service.UserApi

class UserRepository(
    private val userApi: UserApi
) {

    suspend fun fetchUsers(): List<User> {
        val response = userApi.getUsers()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }
}
