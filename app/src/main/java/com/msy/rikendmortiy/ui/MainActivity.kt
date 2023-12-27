package com.msy.rikendmortiy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msy.rikendmortiy.Screen
import com.msy.rikendmortiy.presentation.character_detail.views.CharacterDetailScreen
import com.msy.rikendmortiy.presentation.characters.CharactersViewModel
import com.msy.rikendmortiy.presentation.characters.views.CharactersScreen
import com.msy.rikendmortiy.ui.theme.RikEndMortiyTheme
import com.msy.rikendmortiy.util.Constants.characterID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RikEndMortiyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharactersScreen.route
                    ) {
                        composable(route = Screen.CharactersScreen.route) {
                            CharactersScreen(navController = navController)
                        }
                        composable(route = Screen.CharacterDetailScreen.route + "/{${characterID}}") {
                            CharacterDetailScreen()
                        }
                    }

                }
            }
        }
    }
}
