package com.cece.journal.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppBar(
    title: String = "",
) {
    TopAppBar(
        windowInsets = TopAppBarDefaults.windowInsets,
        title = { Text(text = title) },
//        navigationIcon = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(Icons.Filled.Menu, contentDescription = null)
//            }
//        },
        actions = {
            // RowScope here, so these icons will be placed horizontally
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Search, contentDescription = "Search Journals")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Localized description")
            }
        }
    )
}