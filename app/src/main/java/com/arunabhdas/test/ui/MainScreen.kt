package com.arunabhdas.test.ui

import User
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arunabhdas.test.viewmodel.UserViewModel


@Composable
fun MainScreen(
    viewModel: UserViewModel
) {
    val listOfUser = viewModel.retrieveUsers()

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {

        LazyColumn() {
           items(listOfUser) { user ->
               UserRow(user)
           }
        }
    }
}

@Composable
fun UserRow(
    user: User
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Hello ${user.name}",
            modifier = Modifier.padding(6.dp)
        )

        Text(
            text = "Hello ${user.email}",
            modifier = Modifier.padding(6.dp)
        )

        Text(
            text = "Hello ${user.company.name}",
            modifier = Modifier.padding(6.dp)
        )
    }
}