package com.norameyer.vectorfaq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.norameyer.vectorfaq.ui.theme.VectorFAQTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VectorFAQTheme {
                MainScreen(LocalContext.current)
            }
        }
    }
}
