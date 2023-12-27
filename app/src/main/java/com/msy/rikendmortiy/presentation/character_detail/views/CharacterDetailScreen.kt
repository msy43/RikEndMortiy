package com.msy.rikendmortiy.presentation.character_detail.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.msy.rikendmortiy.R
import com.msy.rikendmortiy.data.remote.dto.character.single.Location
import com.msy.rikendmortiy.data.remote.dto.character.single.Origin
import com.msy.rikendmortiy.domain.model.character.SingleCharacter
import com.msy.rikendmortiy.presentation.character_detail.CharacterDetailViewModel

@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value

    state.character?.let {
        Character(
            character = it,
            painter = rememberAsyncImagePainter(
                model = it.image
            )
        )
    }
}

@Composable
fun Character(
    character: SingleCharacter,
    painter: Painter,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            ) {
                Card(
                    Modifier
                        .width(300.dp)
                        .height(200.dp)
                        .zIndex(1f)
                        .align(Alignment.Center)
                        .shadow(
                            10.dp,
                            ambientColor = colorResource(id = R.color.pink),
                            spotColor = colorResource(id = R.color.pink),
                            clip = false,
                            shape = RectangleShape
                        ),
                    border = BorderStroke(2.dp, colorResource(id = R.color.pink)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.DarkGray
                    )
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(30.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = character.name,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = character.species,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp
                        )

                    }
                }
                Card(
                    Modifier
                        .align(Alignment.TopCenter)
                        .zIndex(1f)
                        .shadow(
                            20.dp,
                            clip = false,
                            shape = RoundedCornerShape(20.dp),
                            ambientColor = colorResource(id = R.color.turquoise),
                            spotColor = colorResource(id = R.color.turquoise)
                        )
                ) {
                    Image(
                        modifier = Modifier
                            .size(150.dp, 150.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        painter = painter,
                        contentDescription = character.name
                    )
                }

                Card(
                    Modifier
                        .width(300.dp)
                        .height(100.dp)
                        .align(Alignment.BottomCenter)
                        .shadow(
                            100.dp,
                            ambientColor = colorResource(id = R.color.turquoise),
                            spotColor = colorResource(id = R.color.turquoise),
                            clip = false,
                            shape = RectangleShape
                        ),
                    border = BorderStroke(2.dp, colorResource(id = R.color.turquoise)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.DarkGray
                    )
                ) {
                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = character.status,
                            color = if (character.status == "Alive") {
                                Color.Green
                            } else {
                                Color.Red
                            },
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp
                        )

                        Text(
                            text = character.origin.name,
                            color = colorResource(id = R.color.turquoise),
                            fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CharacterDetailScreenPreview() {
    Character(
        character =
        SingleCharacter(
            episode = listOf(),
            "Male",
            1,
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            Location("Earth (C-137)", ""),
            "Rick Sanchez",
            Origin("Earth (C-137)", ""),
            "Human",
            "Alive",
        ),
        painter = painterResource(id = R.drawable.demo_image)
    )
}