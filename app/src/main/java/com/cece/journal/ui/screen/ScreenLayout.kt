package com.cece.journal.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.cece.journal.model.Navigator
import com.cece.journal.ui.components.AppBar
import com.cece.journal.ui.components.NavBar

/**
 * defines default screen layout
 * including top appbar and
 * bottom navbar
 * @param nav: MainViewModel
 */
@Composable
fun ScreenLayout(
    nav: Navigator
) {
    Scaffold(
        topBar    = { AppBar() },
        bottomBar = { NavBar(nav) },
    ) { origin ->

        val ver = 10.dp
        val hor = 20.dp
        val inset = PaddingValues(
            top = origin.calculateTopPadding() + ver,
            bottom = origin.calculateBottomPadding() + ver,
            start = origin.calculateStartPadding(LayoutDirection.Ltr) + hor,
            end = origin.calculateStartPadding(LayoutDirection.Ltr) + hor,
        )

        Box(
            modifier = Modifier
                .padding(inset)
                .fillMaxSize()
        ) {
            nav.curr.builder()
        }
    }
}