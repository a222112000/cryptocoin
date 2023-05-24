package com.example.composermvvm.data.remote

import com.example.composermvvm.data.remote.dto.CoinDto
import com.example.composermvvm.data.remote.dto.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCoin {

    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") coinId: String): CoinDetailDto
}