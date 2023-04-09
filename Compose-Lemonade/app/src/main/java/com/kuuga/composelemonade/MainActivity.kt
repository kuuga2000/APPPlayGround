package com.kuuga.composelemonade

import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kuuga.composelemonade.ui.theme.ComposeLemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLemonadeTheme {
                ButtonImage()
            }
        }
    }
}

@Composable
fun ButtonImage() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var lemon: Int by remember { mutableStateOf(1) }
        var steps = arrayOf("Lemon Tree", "Lemon Squeeze", "Lemon Jus","Empy Cup")
        var imageResource = when (lemon) {
            1->R.drawable.lemon_tree
            2->R.drawable.lemon_squeeze
            3->R.drawable.lemon_drink
            4->R.drawable.lemon_restart
            else->R.drawable.lemon_restart
        }

        Column(
            modifier = Modifier.background(Color(0xFF006994)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("${lemon} ${steps[lemon-1]}")
            Image(
                painter = painterResource(imageResource),
                contentDescription = "Lemon Tree",
                modifier = Modifier.clickable {
                    if (lemon >= 4) {
                        lemon = 1
                    } else {
                        lemon++
                    }
                }
            )
        }
    }
}
