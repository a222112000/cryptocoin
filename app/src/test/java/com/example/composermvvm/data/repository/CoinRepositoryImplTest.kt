package com.example.composermvvm.data.repository

import com.example.composermvvm.data.remote.ApiCoin
import com.example.composermvvm.data.remote.dto.CoinDto
import com.example.composermvvm.domain.model.Coin
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CoinRepositoryImplTest {

    @MockK
    private lateinit var coinRepositoryImpl: CoinRepositoryImpl
    private val api = spyk<ApiCoin>()

    private val ID = "bit_coin"
    @Before
    fun setUp() {

        coinRepositoryImpl = CoinRepositoryImpl(api)
    }

    @Test
    fun getCoinsTest() = runBlocking{
        coinRepositoryImpl.getCoins()

        coVerify { coinRepositoryImpl.getCoins() }
    }

    @Test
    fun getCoinDetailsTest() = runBlocking{
        coinRepositoryImpl.getCoinDetail(ID)
        coVerify { coinRepositoryImpl.getCoinDetail(ID) }
    }
}