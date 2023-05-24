package com.example.composermvvm.domain.usecase.getCoins

import com.example.composermvvm.common.Resource
import com.example.composermvvm.data.remote.dto.toCoin
import com.example.composermvvm.domain.model.Coin
import com.example.composermvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke():Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Unknown error"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server check your internet connection"))
        }
    }
}