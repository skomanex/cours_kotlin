package com.example.cours_kotlin.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.cours_kotlin.R
import com.example.cours_kotlin.exo.MainViewModel
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    position: Int,
    navHostController: NavHostController? = null,
    viewModel: MainViewModel
){
    val data = viewModel.myList[position]
    Column(modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = data.text,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.size(4.dp))
        GlideImage(
            model = data.url,
            contentDescription = data.text,
            loading = placeholder(R.mipmap.ic_launcher_round), // Image de chargement
            // Image d'échec. Permet également de voir l'emplacement de l'image dans la Preview
            failure = placeholder(R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.weight(1f)

        )
        Row(modifier = Modifier.fillMaxWidth().weight(1f), horizontalArrangement = Arrangement.Center){
            CustomButton(text = "Retour", icon = Icons.Filled.ArrowBack) { navHostController?.popBackStack() }
        }
    }
}