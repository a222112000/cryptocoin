package com.example.composermvvm.presentation

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("list_coins")
    object CoinDetailScreen: Screen("coin_detail")
}