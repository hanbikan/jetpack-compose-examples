package com.hanbitkang.listanddetailview.ui.list

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hanbitkang.listanddetailview.NavigationDestination

object PokemonListDestination : NavigationDestination {
    override val route = "pokemon_list_route"
}

fun NavGraphBuilder.pokemonListGraph() {
    composable(route = PokemonListDestination.route) {
        PokemonList()
    }
}