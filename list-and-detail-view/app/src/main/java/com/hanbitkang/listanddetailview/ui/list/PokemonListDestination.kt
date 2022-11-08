package com.hanbitkang.listanddetailview.ui.list

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hanbitkang.listanddetailview.NavigationDestination

object PokemonListDestination : NavigationDestination {
    override val route = "pokemon_list_route"
}

fun NavGraphBuilder.pokemonListGraph(navController: NavController) {
    composable(route = PokemonListDestination.route) {
        PokemonList(navController)
    }
}