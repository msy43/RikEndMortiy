package com.msy.rikendmortiy.presentation.characters.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import com.msy.rikendmortiy.R
import com.msy.rikendmortiy.data.remote.dto.character.all.Location
import com.msy.rikendmortiy.data.remote.dto.character.all.Origin
import com.msy.rikendmortiy.domain.model.character.AllCharacter

@Composable
fun CharacterItem(
    character: AllCharacter,
    painter: Painter,
    onItemClick: (Int) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(20.dp)
            .clickable {
                onItemClick(character.id)
            }
            .shadow(
                100.dp,
                ambientColor = colorResource(id = R.color.turquoise),
                spotColor = colorResource(id = R.color.turquoise),
                clip = false,
                shape = RectangleShape
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        border = BorderStroke(1.dp, colorResource(id = R.color.turquoise)),
    ) {

        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp, 150.dp)
                    .align(CenterHorizontally)
                    .clip(RoundedCornerShape(20.dp)),
                painter = painter,
                contentDescription = character.name
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = character.name,
                color = colorResource(id = R.color.pink),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = character.species,
                    color = colorResource(id = R.color.turquoise),
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )

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

            }

            Spacer(modifier = Modifier.height(16.dp))

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

@Preview
@Composable
fun CharacterItemPreview() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        CharacterItem(
            AllCharacter(
                "Male",
                1,
                "https://rickandmortyapi.com/api/character/avatar/37.jpeg",
                Location("A", "B"),
                "Abadango Cluster Princess",
                Origin("Earth (C-137)", "B"),
                "Human",
                "Alive",
            ),
            painter = painterResource(id = R.drawable.demo_image),
            onItemClick = {}
        )
    }

}