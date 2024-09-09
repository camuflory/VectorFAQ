package com.norameyer.vectorfaq

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    activity: Activity,
    mvm: MainViewModel = viewModel(factory = MainViewModel.factory)
) {

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(title = { },
            navigationIcon = {
                IconButton(onClick = {
                    mvm.answer.value = ""
                    mvm.question.value = ""
                    mvm.qa = null
                    activity.finish()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back"
                    )
                }
            },
            actions = {
                IconButton(onClick = {
                    mvm.insertItem()
                    activity.finish()
                }) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "done")
                }
            }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            value = mvm.question.value,
            onValueChange = { mvm.question.value = it },
            label = { Text(text = "вопрос") },
            maxLines = 1
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            value = mvm.answer.value,
            onValueChange = { mvm.answer.value = it },
            label = { Text(text = "ответ") },
            maxLines = 1
        )

    }

}