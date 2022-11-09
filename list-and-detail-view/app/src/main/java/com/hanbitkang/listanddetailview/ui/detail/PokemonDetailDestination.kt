package com.hanbitkang.listanddetailview.ui.detail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.hanbitkang.listanddetailview.NavigationDestination
import com.hanbitkang.listanddetailview.model.Pokemon
import com.hanbitkang.listanddetailview.ui.detail.PokemonDetailDestination.pokemonIndexArg

object PokemonDetailDestination : NavigationDestination {
    const val pokemonIndexArg = "pokemon_index"
    override val route = "pokemon_detail_route"
}

fun NavGraphBuilder.pokemonDetailGraph(navController: NavController) {
    composable(
        route = "${PokemonDetailDestination.route}/{${pokemonIndexArg}}",
        arguments = listOf(
            navArgument(pokemonIndexArg) { type = NavType.IntType }
        )
    ) {
        val index = it.arguments?.getInt(pokemonIndexArg)
        val pokemon = Pokemon("https://pokeapi.co/api/v2/pokemon/$index/", "Pokemon$index")
        PokemonDetail(pokemon)
    }
}