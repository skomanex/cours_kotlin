package com.example.cours_kotlin.ui.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.cours_kotlin.R
import com.example.cours_kotlin.Routes
import com.example.cours_kotlin.exo.MainViewModel
import com.example.cours_kotlin.exo.PictureData


@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController? = null,
    viewModel: MainViewModel
){
    var searchText = viewModel.searchText
    val filterList = viewModel.myList.filter{it.text.lowercase().contains(searchText.lowercase())}

    Column(modifier) {
        SearchBar(textValue = searchText) {
            viewModel.uploadSearchText(it)
        }
        Spacer(modifier = Modifier.size(4.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(filterList.size) {
                PictureRowItem(filterList[it]){navHostController?.navigate(Routes.DetailScreen.addParam(it))}
            }
        }
        Spacer(modifier = Modifier.size(4.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            CustomButton(text = "Clear Filters", icon = Icons.Filled.Clear){
                viewModel.uploadSearchText("")
            }
            Spacer(modifier = Modifier.size(20.dp))
            CustomButton(text = "Load Data", icon = Icons.Filled.Send)
            {
                viewModel.loadData()
            }
        }
    }
}

@Composable
fun CustomButton(text:String, icon: ImageVector = Icons.Filled.Favorite, onClick:() -> Unit){
    Button(
        onClick = onClick,
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Icon(
            icon,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier, textValue: String, onValueChange:(String)->Unit){
    Column(modifier = modifier){
        TextField(
            value = textValue, //Valeur par défaut
            onValueChange = onValueChange, //Action
            leadingIcon = { //Image d'icone
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null
                )
            },
            label = { Text("Recherche") }, //Texte d'aide qui se déplace
            //Comment le composant doit se placer
            modifier = Modifier
                .fillMaxWidth() //prend toute la largeur
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PictureRowItem(data: PictureData, onPictureClick: () -> Unit = {}) {
    var extend by remember { mutableStateOf(false) }
    val extendtext = if (extend) data.longText else data.longText.take(20)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 100.dp)
    ) {
        Column(Modifier.clickable { onPictureClick() }) {
            GlideImage(
                model = data.url,
                contentDescription = data.text,
                loading = placeholder(R.mipmap.ic_launcher_round), // Image de chargement
                // Image d'échec. Permet également de voir l'emplacement de l'image dans la Preview
                failure = placeholder(R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Fit,
                //même autres champs qu'une Image classique
            )
        }
        Spacer(Modifier.size(4.dp))
        Column(Modifier.clickable { extend = !extend }.animateContentSize()) {
            Text(
                text = data.text,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Spacer(Modifier.size(12.dp))
            Text(
                text = extendtext,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
    }
}