package com.example.rickandmorty.ui.view.view


import Drawer
import TopBar
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import kotlinx.coroutines.CoroutineScope


@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed ))
    val scope = rememberCoroutineScope()
    val charactersList by viewModel.getCharacters().observeAsState(initial = emptyList())
    val list = listOf<String>("Option 1", "Option 2", "Option 3", "Option 4" )
    ListViewCharacters(navController, scaffoldState, scope, charactersList, list)

}

@Composable
fun ListViewCharacters(

    navController: NavController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    characters: List<Character>,
    list: List<String>


) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope, scaffoldState ) },
        drawerContent = {Drawer(scope, scaffoldState , navController , items = list)},
        drawerGesturesEnabled = true
        )
    {
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
        ) {
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
    val scaffoldState = rememberScaffoldState(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed ))
    val scope = rememberCoroutineScope()
    val list = listOf<String>("Option 1", "Option 2", "Option 3", "Option 4" )
    ListViewCharacters(
        navController = rememberNavController(), scaffoldState , scope, characters = arrayListOf(
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
        ),
        list = list
    )
}


