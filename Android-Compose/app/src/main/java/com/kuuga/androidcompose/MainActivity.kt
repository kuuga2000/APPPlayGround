package com.kuuga.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuuga.androidcompose.ui.theme.AndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                ) {

                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraLight
                    )
                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W900
                    )
                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        "Hello World",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black
                    )

                }

            }
        }
    }
}