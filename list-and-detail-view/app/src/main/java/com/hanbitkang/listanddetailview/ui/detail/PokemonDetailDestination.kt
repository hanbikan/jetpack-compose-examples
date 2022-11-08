package com.hanbitkang.listanddetailview.ui.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hanbitkang.listanddetailview.NavigationDestination

object PokemonDetailDestination : NavigationDestination {
    override val route = "pokemon_detail_route"
}

fun NavGraphBuilder.pokemonDetailGraph() {
    composable(route = PokemonDetailDestination.route) {

    }
}