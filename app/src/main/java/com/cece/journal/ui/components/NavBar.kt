package com.cece.journal.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cece.journal.model.Navigator
import com.cece.journal.util.enum.Route

@Composable
fun NavBar(
    nav: Navigator
) {
    /* bottom nav items */
    val navItems = arrayOf(
        Route.HOME,
        Route.DATE,
    )

    BottomAppBar(
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
        ) {
            navItems.forEach{item ->
                IconButton(onClick = { nav.navigate(item) }) {
                    Icon(
                        item.icon(),
                        contentDescription = item.name
                    )
                }
            }
        }
    }
}