package com.example.composermvvm.presentation.coinListScreen

import com.example.composermvvm.domain.model.Coin

data class CoinState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)