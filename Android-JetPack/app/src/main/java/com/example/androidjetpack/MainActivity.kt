package com.example.androidjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidjetpack.ui.theme.AndroidJetPackTheme
import com.example.androidjetpack.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        Greeting("Android")
                        CustomText(name = "Grim Stroke")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CustomText(name: String) {
    Text(
        text = name,
        style = Typography.h1
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidJetPackTheme {
        Column(
            modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.width(200.dp).weight(1f),
                color = MaterialTheme.colors.secondary
            ) {

            }

            Surface(
                modifier = Modifier.width(200.dp).weight(3f),
                color = MaterialTheme.colors.primary
            ) {

            }



        }

    }
}