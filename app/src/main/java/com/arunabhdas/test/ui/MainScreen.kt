package com.arunabhdas.test.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arunabhdas.test.viewmodel.UserState
import com.arunabhdas.test.viewmodel.UserViewModel

@Composable
fun MainScreen(
    viewModel: UserViewModel = viewModel()
) {
    val uiState by viewModel.userUiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        LazyColumn {
            items(uiState.userList) { user ->
                UserRow(user)
            }
        }
    }
}

@Composable
fun UserRow(
    user: UserState
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = user.name,
            modifier = Modifier.padding(6.dp)
        )

        Text(
            text = user.email,
            modifier = Modifier.padding(6.dp)
        )

        Text(
            text = user.companyName,
            modifier = Modifier.padding(6.dp)
        )
    }
}
