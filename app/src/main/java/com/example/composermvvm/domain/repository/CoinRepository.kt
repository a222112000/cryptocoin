package com.example.composermvvm.domain.repository

import com.example.composermvvm.data.remote.dto.CoinDto
import com.example.composermvvm.data.remote.dto.CoinDetailDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinDetail(coinId:String): CoinDetailDto
}