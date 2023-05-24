package com.example.composermvvm.presentation.detailCoinScreen

import com.example.composermvvm.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)