package com.norameyer.vectorfaq

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    context: Context,
    mvm: MainViewModel = viewModel(factory = MainViewModel.factory)
) {

    val allQA = mvm.allQA.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "FAQ",
                        fontSize = 22.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                actions = {
                    FloatingActionButton(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        containerColor = Color.DarkGray,
                        contentColor = Color.White,
                        onClick = {
                            context.startActivity(
                                Intent(
                                    context,
                                    EditActivity::class.java
                                ).putExtra("creating", true)
                            )
                        }
                    ) {
                        Icon(Icons.Filled.Add, "add new Q&A")
                    }
                })
        },
        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(allQA.value) { qa ->
                        ListItem(qa, {
                            context.startActivity(
                                Intent(
                                    context,
                                    EditActivity::class.java
                                )
                                    .putExtra("creating", false)
                                    .putExtra("q", qa.question)
                                    .putExtra("a", qa.answer)
                                    .putExtra("id", qa.id)
                            )
                        }, { mvm.deleteItem(qa) })
                    }
                }
            }
        }
    )
}