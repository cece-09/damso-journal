package com.cece.journal.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cece.journal.util.enum.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Navigator @Inject constructor() : ViewModel() {
    var curr by mutableStateOf(Route.HOME)
        private set

    /* navigate to page */
    fun navigate(route: Route) {
        curr = route;
    }
}