package com.norameyer.vectorfaq

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DeletingAlertDialog(onDissmiss: () -> Unit) {


    AlertDialog(
        onDismissRequest = { /* */ },
        confirmButton = { /* */ },
        title = {
            Text(
                text = "Удалить этот вопрос и ответ?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        },
        text = { Text(text = "Вопрос и ответ будут удалены безвозвратно") }
    )
}