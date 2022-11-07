package com.hanbitkang.listanddetailview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hanbitkang.listanddetailview.model.Pokemon
import com.hanbitkang.listanddetailview.ui.theme.ListAndDetailViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListAndDetailViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val pokemonList = (1 until 20)
                        .map { Pokemon("https://pokeapi.co/api/v2/pokemon/$it/", "Pokemon$it") }
                    PokemonList(pokemonList)
                }
            }
        }
    }
}

@Composable
fun PokemonList(pokemonList: List<Pokemon>) {
    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonCard(pokemon)
        }
    }
}

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PokemonImage(pokemonImageUrl = pokemon.getImageUrl())
        Text(
            text = pokemon.name?: "",
            fontSize = 32.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun PokemonImage(pokemonImageUrl: String?) {
    AsyncImage(
        model = pokemonImageUrl,
        contentDescription = null,
        modifier = Modifier
            .width(96.dp)
            .height(96.dp)
    )
}