package com.kuuga.compose_artspace

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuuga.compose_artspace.data.ImageMap
import com.kuuga.compose_artspace.ui.theme.ComposeArtSpaceTheme
import com.kuuga.compose_artspace.ui.theme.ShadowGrey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    color = MaterialTheme.colors.background
                ) {
                    GalleryScreen()
                }
            }
        }
    }
}

@Composable
fun GalleryScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(1f)
    ) {
        var indexNumber by remember { mutableStateOf(value = 1) }
        val imageList = listOf(
            ImageMap(
                image = R.drawable.kamen_rider_zero_one,
                caption = "Kamen Rider Zero One"
            ),
            ImageMap(
                image = R.drawable.kamen_rider_build,
                caption = "Kamen Rider Build"
            ),
            ImageMap(
                image = R.drawable.kamen_rider_vulcan,
                caption = "Kamen Rider Vulcan"
            )
        )
        Picture(src = imageList[indexNumber].image)
        Spacer(modifier = Modifier.height(10.dp))
        Caption(text= "#" + (indexNumber + 1) + ". "+ imageList[indexNumber].caption)
        Row(
            modifier = Modifier.fillMaxWidth(fraction = 0.9f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonAction(
                onClicked = {
                    indexNumber--
                    if (indexNumber<0) {
                        indexNumber = 2
                    }
                },
                text = "Previous"
            )
            ButtonAction(
                onClicked = {
                    indexNumber++
                    if (indexNumber>2) {
                        indexNumber = 0
                    }
                },
                text = "Next"
            )
        }
    }
}
@Composable
fun Picture(src: Int) {
    Card(
        elevation= 10.dp
    ) {
        Image(
            painter = painterResource(id = src),
            contentDescription = "Kamen Rider",
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .border(width = 1.dp, color = ShadowGrey)
                .fillMaxHeight(fraction = 0.7f)
        )
    }
}

@Composable
fun Caption(text: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .background(color = ShadowGrey)
            .padding(vertical = 20.dp, horizontal = 10.dp)

    ) {
        Text(text = text)
    }
}

/*
@Composable
fun Buttons() {
    Row(
        modifier = Modifier.fillMaxWidth(fraction = 0.9f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ButtonAction(
            text = "Previous"
        )
        ButtonAction(
            text = "Next"
        )
    }
}*/

@Composable
fun ButtonAction(text: String, onClicked: () -> Unit) {
    Button(
        onClick = onClicked
    ) {
        Text(text = text)
    }
}

/*
modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 20.dp)
                                .border(width = 1.dp, color = ShadowGrey),
                            horizontalAlignment = Alignment.CenterHorizontally
 */