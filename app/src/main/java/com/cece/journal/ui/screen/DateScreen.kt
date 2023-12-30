package com.cece.journal.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cece.journal.model.Navigator
import com.cece.journal.util.enum.Route

@Composable
fun DateScreen(
    nav: Navigator = viewModel(),
) {
    Column(
    ) {
        Text(text = "This is DateScreen!")
        Button(onClick = { nav.navigate(Route.HOME) }) {
            Text(text = "Home Screen")
        }
    }
}