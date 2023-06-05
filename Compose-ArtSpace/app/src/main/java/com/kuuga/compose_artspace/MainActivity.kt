package com.kuuga.compose_artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    modifier = Modifier.fillMaxSize(),
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
        Picture()
        Spacer(modifier = Modifier.height(10.dp))
        Caption()
        ButtonContainer()
    }
}
@Composable
fun Picture() {
    Card(
        elevation= 10.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.kamen_rider_zero_one),
            contentDescription = "Kamen Rider",
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .border(width = 1.dp, color = ShadowGrey)
        )
    }
}

@Composable
fun Caption() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .background(color = ShadowGrey)
            .padding(vertical = 20.dp, horizontal = 10.dp)

    ) {
        Text(text = "TEST")
        Text(text = "TEST2")
    }
}

@Composable
fun ButtonContainer() {
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
}

@Composable
fun ButtonAction(text: String) {
    Button(onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}

/*
modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 20.dp)
                                .border(width = 1.dp, color = ShadowGrey),
                            horizontalAlignment = Alignment.CenterHorizontally
 */