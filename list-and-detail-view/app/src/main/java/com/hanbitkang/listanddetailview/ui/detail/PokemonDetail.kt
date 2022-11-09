package com.hanbitkang.listanddetailview.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.hanbitkang.listanddetailview.model.Pokemon
import com.hanbitkang.listanddetailview.ui.list.PokemonImage

@Composable
fun PokemonDetail(pokemon: Pokemon) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        PokemonImage(pokemonImageUrl = pokemon.getImageUrl(), size = 256)
        Text(
            text = pokemon.name?: "",
            fontSize = 48.sp
        )
    }
}