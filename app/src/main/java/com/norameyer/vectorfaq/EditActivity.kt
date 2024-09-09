package com.norameyer.vectorfaq

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.norameyer.vectorfaq.data.QAEntity
import com.norameyer.vectorfaq.ui.theme.VectorFAQTheme

class EditActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mvm: MainViewModel = viewModel(factory = MainViewModel.factory)
            VectorFAQTheme {

                if (intent.extras?.getBoolean("creating") == false) {
                    val item = QAEntity(
                        intent.extras?.getInt("id"),
                        intent.extras?.getString("q").toString(),
                        intent.extras?.getString("a").toString()
                    )
                    mvm.qa = item
                    mvm.answer.value = item.answer
                    mvm.question.value = item.question
                }

                EditScreen(LocalContext.current as Activity)
            }
        }
    }
}
