package com.example.composermvvm.data.repository

import com.example.composermvvm.data.remote.dto.CoinDto
import com.example.composermvvm.data.remote.dto.CoinDetailDto
import com.example.composermvvm.data.remote.ApiCoin
import com.example.composermvvm.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiCoin: ApiCoin
):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return apiCoin.getCoins()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto {
        return apiCoin.getCoinDetails(coinId)
    }
}