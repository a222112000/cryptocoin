package com.example.composermvvm.domain.usecase.getCoin

import com.example.composermvvm.common.Resource
import com.example.composermvvm.data.remote.dto.toCoinDetail
import com.example.composermvvm.domain.model.CoinDetail
import com.example.composermvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String):Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = repository.getCoinDetail(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Unknown Error occur"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server please check your imnternet"))
        }
    }
}