package com.cece.journal.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cece.journal.model.HomeViewModel
import com.cece.journal.ui.components.EditorSheet
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    vm: HomeViewModel = viewModel()
)  {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val journals by vm.journals.observeAsState()

    Column(
        verticalArrangement = Arrangement.Bottom,
    ) {

        /* title */
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()) {
            Text(
                text = "오늘",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        /* book shelf */

        /* list */
        Box(modifier = Modifier
            .weight(10f)
            .fillMaxWidth()) {
            Column {
                /* lazy columns */
                LazyColumn {
                    items(journals.orEmpty()) { journal ->
                        // TODO: change to journal card
                        Text(text = journal.content ?: "")
                    }
                }

                Button(onClick = {
                    showBottomSheet = true
                }) {
                    Text(text = "일기 작성하기")
                }
            }
        }

        /* bottom sheet */
        if(showBottomSheet) {
            EditorSheet(
                closeSheet = { showBottomSheet = false },
                sheetState = sheetState,
                scope = scope,
            )
        }
    }
}
