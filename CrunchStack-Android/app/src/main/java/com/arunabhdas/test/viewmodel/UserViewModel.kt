package com.arunabhdas.test.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.arunabhdas.test.repository.UserRepository
import com.arunabhdas.test.service.RetrofitHelper
import com.arunabhdas.test.service.UserApi

class UserViewModel : ViewModel() {
    private val _userUiState: MutableStateFlow<UserUiState> = MutableStateFlow(UserUiState(emptyList()))

    val userUiState: StateFlow<UserUiState> = _userUiState.asStateFlow()

    private val userApi = RetrofitHelper.getInstance().create(UserApi::class.java)
    private val repository: UserRepository = UserRepository(userApi)

    init {
        retrieveUsers()
    }

    private fun retrieveUsers() {
        viewModelScope.launch {
            val users = repository.fetchUsers()
            _userUiState.value = UserUiState(
                userList = users.map { user ->
                    UserState(
                        name = user.name,
                        email = user.email,
                        companyName = user.company.name
                    )
                }
            )
        }
    }
}

data class UserUiState(
    val userList: List<UserState>
)

data class UserState(
    val name: String,
    val email: String,
    val companyName: String
)
