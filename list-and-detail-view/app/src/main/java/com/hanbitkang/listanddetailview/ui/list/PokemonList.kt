package com.hanbitkang.listanddetailview.ui.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.hanbitkang.listanddetailview.model.Pokemon
import com.hanbitkang.listanddetailview.ui.detail.PokemonDetailDestination

@Composable
fun PokemonList(navController: NavController) {
    // TODO: Replace into data from server
    val pokemonList = (1 until 20)
        .map { Pokemon("https://pokeapi.co/api/v2/pokemon/$it/", "Pokemon$it") }

    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonCard(pokemon, navController)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonCard(pokemon: Pokemon, navController: NavController) {
    Card(onClick = {
        navController.navigate(PokemonDetailDestination.route)
    }) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PokemonImage(pokemonImageUrl = pokemon.getImageUrl(), 96)
            Text(
                text = pokemon.name?: "",
                fontSize = 32.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Composable
fun PokemonImage(pokemonImageUrl: String?, size: Int) {
    AsyncImage(
        model = pokemonImageUrl,
        contentDescription = null,
        modifier = Modifier
            .width(size.dp)
            .height(size.dp)
    )
}