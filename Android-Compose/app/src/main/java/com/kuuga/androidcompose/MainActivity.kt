package com.kuuga.androidcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
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
                    Row()
                    CreateColumn();
                    CreateTextField()
                    CreateButton()
                    DisplayImage()
                    CosCard()
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

@Composable
fun DisplayImage()
{
    Image(
        painter = painterResource(id = R.drawable.blacksun),
        contentDescription = "Kamen Rider Black Sun Reboot",
        modifier = Modifier.padding(top = 50.dp).clip(CutCornerShape(50.dp))
    )
}

@Composable
fun CosCard()
{
    Card(elevation = 4.dp, modifier = Modifier.padding(all = 10.dp), backgroundColor = Color.Green) {
        Column(modifier = Modifier.padding(all = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Welcome")
            Text("to")
            Text("The Club")
            DisplayImage()
        }
    }
}

@Composable
fun Row()
{
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)
    ) {
        Text("Burger", modifier = Modifier.BgRed())
        Text("Logo", modifier = Modifier.BgRed())
        Text("Wishlist", modifier = Modifier.BgRed())
    }
}

@Composable
fun Modifier.BgRed():Modifier = background(Color.Red)
fun Modifier.BgBlue():Modifier = background(Color.Blue)