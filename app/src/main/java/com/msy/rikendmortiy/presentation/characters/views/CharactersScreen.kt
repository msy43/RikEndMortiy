package com.msy.rikendmortiy.presentation.characters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import com.msy.rikendmortiy.R
import com.msy.rikendmortiy.Screen
import com.msy.rikendmortiy.data.remote.dto.character.all.Location
import com.msy.rikendmortiy.data.remote.dto.character.all.Origin
import com.msy.rikendmortiy.domain.model.character.AllCharacter
import com.msy.rikendmortiy.presentation.characters.CharactersViewModel

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Characters",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.characters) { character ->
                    CharacterItem(
                        character = character,
                        painter = rememberAsyncImagePainter(
                            model = character.image
                        ),
                        onItemClick = {
                            navController.navigate(Screen.CharacterDetailScreen.route + "/${it}")
                        }
                    )
                }
            }

        }
    }
}


@Preview
@Composable
fun CharactersScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Characters",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            for (i in 0..3) {
                CharacterItem(
                    character =
                    AllCharacter(
                        "Male",
                        1,
                        "https://rickandmortyapi.com/api/character/avatar/37.jpeg",
                        Location("A", "B"),
                        "Rick Sanchez",
                        Origin("Earth (C-137)", "B"),
                        "Human",
                        "Alive",
                    ),

                    painter = painterResource(id = R.drawable.demo_image),
                    onItemClick = {}
                )
            }
        }
    }
}