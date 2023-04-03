package com.example.androidjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 50.dp, bottom = 50.dp)
                    .border(5.dp, Color.Magenta)
                    .background(Color.Yellow),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Hello", Modifier.TextStyle(),Color(0xFF03DAC5))
                Spacer(modifier = Modifier.height(80.dp))
                Text("World", Modifier.TextStyle(), Color(0xFF03DAC5))
            }
        }
    }
}

fun Modifier.TextStyle():Modifier = composed {
    offset(50.dp, 20.dp)
    background(Color.Red)
}