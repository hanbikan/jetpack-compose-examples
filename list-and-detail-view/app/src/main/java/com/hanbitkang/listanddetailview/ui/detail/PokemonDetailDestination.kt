package com.hanbitkang.listanddetailview.ui.detail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hanbitkang.listanddetailview.NavigationDestination

object PokemonDetailDestination : NavigationDestination {
    override val route = "pokemon_detail_route"
}

fun NavGraphBuilder.pokemonDetailGraph(navController: NavController) {
    composable(route = PokemonDetailDestination.route) {
        PokemonDetail()
    }
}