package com.kuuga.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text;
import androidx.compose.ui.graphics.Color
import com.kuuga.androidcompose.ui.theme.AndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme {
                Text("Hello World", color = Color.Red)
            }
        }
    }
}