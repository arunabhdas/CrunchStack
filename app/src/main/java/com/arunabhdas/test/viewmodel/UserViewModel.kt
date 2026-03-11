package com.arunabhdas.test.viewmodel

import User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.emptyList
import com.arunabhdas.test.repository.UserRepository
import com.arunabhdas.test.service.RetrofitHelper
import com.arunabhdas.test.service.UserApi

class UserViewModel(
    userRepository: UserRepository
) {
    private val _userUiState: MutableStateFlow<UserUiState?> = MutableStateFlow<UserUiState?>(null);

    val userUiState: StateFlow<UserUiState?> = _userUiState.asStateFlow()


    val userApi = RetrofitHelper.getInstance().create(UserApi::class.java)

    val repository: UserRepository = UserRepository(userApi)

    //
    fun retrieveUsers(
    ): List<User> {
        return repository.fetchUsers()
    }


}

data class UserUiState (
    val userList: List<UserState>
)

data class UserState (
    val name: String,
    val email: String,
    val companyName: String
)
