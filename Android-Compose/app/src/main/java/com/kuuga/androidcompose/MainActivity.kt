package com.kuuga.androidcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
                ) {
                    WelcomeText(text = "Dinosaurus")
                    CreateTextField()
                    CreateButton()
                }
            }
        }
    }
}

@Composable
fun WelcomeText(text: String)
{
    SelectionContainer() {
        Text("Hello $text", fontStyle = FontStyle.Italic)
    }
}

@Composable
fun CreateTextField()
{
    var customerName by remember { mutableStateOf("") }
    OutlinedTextField(
        value = customerName,
        onValueChange = {customerName = it},
        label = { Text("Type Your name")}
    )
    Text(customerName)
}

@Composable
fun CreateButton()
{
    val context  = LocalContext.current
    Button(onClick = { Toast.makeText(context, "Welcome", Toast.LENGTH_LONG).show() }) {
        Text ("Submit Proposal");
    }
}