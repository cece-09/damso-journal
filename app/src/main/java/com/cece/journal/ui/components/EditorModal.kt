package com.cece.journal.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cece.journal.model.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EditorSheet (
    closeSheet: () -> Unit,
    sheetState: SheetState,
    scope: CoroutineScope,
    vm: HomeViewModel = viewModel(),
) {
    val requester = FocusRequester()
    val content by vm.content.observeAsState("")

    /* editor text field style options */
    val colors = TextFieldDefaults.colors(
        focusedTextColor        = MaterialTheme.colorScheme.onBackground,
        unfocusedTextColor      = MaterialTheme.colorScheme.onBackground,
        disabledTextColor       = MaterialTheme.colorScheme.onBackground,
        errorTextColor          = MaterialTheme.colorScheme.onBackground,
        focusedContainerColor   = MaterialTheme.colorScheme.background,
        unfocusedContainerColor = MaterialTheme.colorScheme.background,
        disabledContainerColor  = MaterialTheme.colorScheme.background,
        errorContainerColor     = MaterialTheme.colorScheme.background,
//        focusedPlaceholderColor: Color,
//        unfocusedPlaceholderColor: Color,
//        disabledPlaceholderColor: Color,
//        errorPlaceholderColor: Color,
    )

    ModalBottomSheet(
        onDismissRequest = { closeSheet() },
        sheetState = sheetState,
    ) {

        /* auto-focus when launched */
        LaunchedEffect(sheetState) {
            requester.requestFocus()
        }

        Column(
            modifier = Modifier
                .padding(all = 10.dp)
                .height(600.dp)
        ) {
            /* bottom sheet header */
            Row(
                modifier = Modifier.fillMaxWidth().weight(2f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(Icons.Rounded.Check, contentDescription = null)
                Text(text = vm.today)
                Button(onClick = {
                    scope.launch {
                        vm.save()
                        sheetState.hide()
                    }.invokeOnCompletion { error ->
                        if(error == null) {
                            scope.launch(Dispatchers.Main) {
                                closeSheet()
                            }
                        }
                    }
                }) {
                    Text(text = "완료")
                }
            }


            /* text field */
            TextField(
                value = content,
                onValueChange = { vm.updateContent(it) },
                singleLine = false,
                colors = colors,
                modifier = Modifier
                    .focusRequester(requester)
                    .fillMaxWidth()
                    .weight(8f)
            )
            
            /* media pickers */
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().weight(2f)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Rounded.Build, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Rounded.Build, contentDescription = null)
                }
            }
        }
    }
}