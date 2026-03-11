package com.arunabhdas.test.repository

import User
import com.arunabhdas.test.service.UserApi

class UserRepository(
    userApi: UserApi
) {

    fun fetchUsers(): List<User> {
        return emptyList()
    }
}