package com.hanbitkang.listanddetailview.model

data class Pokemon(
    val url: String,
    val name: String?
) {
    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    }

    companion object {
        fun getDummy() = Pokemon("https://pokeapi.co/api/v2/pokemon/1/", "Pokemon")
    }
}