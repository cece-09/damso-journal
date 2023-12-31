package com.cece.journal.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cece.journal.data.entity.Journal
import com.cece.journal.model.HomeViewModel
import com.cece.journal.util.extension.toViewString
import kotlinx.coroutines.launch

@Composable
fun JournalCard(
    journal: Journal,
    vm: HomeViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(15.dp),
                ambientColor = Color.Blue,
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(15.dp)
            ),
    ) {
        /* data fields */
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            text = journal.content ?: ""
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            /* show date */
            Text(text = journal.date.toViewString())

            /* delete, edit buttons */
            IconButton(onClick = {
                scope.launch { vm.delete(journal) }
            }) {
                Icon(
                    Icons.Rounded.Delete,
                    contentDescription = "delete journal",
                )
            }
        }
    }
}