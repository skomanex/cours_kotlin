package com.example.cours_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cours_kotlin.exo.pictureList
import com.example.cours_kotlin.ui.screen.PictureRowItem
import com.example.cours_kotlin.ui.screen.SearchScreen
import com.example.cours_kotlin.ui.theme.Cours_kotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cours_kotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
                    SearchScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Cours_kotlinTheme {
        Greeting()
    }
}

@Composable
fun Greeting() {
    Column {
        PictureRowItem(pictureList[0])
    }
}