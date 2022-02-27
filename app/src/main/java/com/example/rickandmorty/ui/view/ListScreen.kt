package com.example.rickandmorty.ui.view.view


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.rickandmorty.R
import com.example.rickandmorty.data.Character
import com.example.rickandmorty.data.model.Gender
import com.example.rickandmorty.data.model.Species
import com.example.rickandmorty.data.model.Status
import com.example.rickandmorty.ui.viewmodel.ListScreenViewModel


@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val charactersList by viewModel.getCharacters().observeAsState(initial = emptyList())
    ListViewCharacters(navController, charactersList)
}

@Composable
fun ListViewCharacters(
    navController: NavController,
    characters: List<Character>

) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Ricky and Morty", color = Color.White) })
        }) {
        LazyColumn {
            items(characters) { character ->
                MessageRow(character)

            }

        }

    }
}

@Composable
fun MessageRow(character: Character) {
    Row(
        Modifier
            .clickable { Log.i("Tag", "---> has pulsado un item") }
            .background(color = Color.White)
            .height(180.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .size(150.dp)
                .padding(10.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),

                painter = rememberImagePainter(
                    data = character.image,
                    builder = {
                        placeholder(R.drawable.placeholder)
                        error(R.drawable.placeholder)
                    }
                ),
                contentDescription = null,
            contentScale = ContentScale.Fit)
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = "${character.name}",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,

                color = Color.Gray,
                fontSize = 25.sp
            )
        }
    }
}

@Preview
@Composable
fun ListViewPrev() {
    ListViewCharacters(
        navController = rememberNavController(), characters = arrayListOf(
            Character(
                1,
                "Rick Sanchez",
                Status.Alive,
                Species.Human,
                "",
                Gender.Male,
                null,
                null,
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                null,
                "https://rickandmortyapi.com/api/character/1",
                "2017-11-04T18:48:46.250Z"
            ),
            Character(
                1,
                "Morty Smith",
                Status.Alive,
                Species.Human,
                "",
                Gender.Male,
                null,
                null,
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                null,
                "https://rickandmortyapi.com/api/character/1",
                "2017-11-04T18:48:46.250Z"
            ),
            Character(
                1,
                "Summer Smith",
                Status.Alive,
                Species.Human,
                "",
                Gender.Male,
                null,
                null,
                "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
                null,
                "https://rickandmortyapi.com/api/character/1",
                "2017-11-04T18:48:46.250Z"
            ),
        )
    )
}


