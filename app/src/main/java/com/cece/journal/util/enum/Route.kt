package com.cece.journal.util.enum

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.cece.journal.ui.screen.DateScreen
import com.cece.journal.ui.screen.HomeScreen
import com.cece.journal.util.`typealias`.ScreenBuilder


enum class Route(val builder: ScreenBuilder ) {
    HOME   ( { HomeScreen() } ),
    DATE   ( { DateScreen() } ),;


    fun icon(): ImageVector {
        return when(this) {
            HOME -> Icons.Rounded.Home
            DATE -> Icons.Rounded.Favorite
        }
    }
}
