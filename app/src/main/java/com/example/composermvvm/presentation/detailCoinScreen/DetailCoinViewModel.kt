package com.example.composermvvm.presentation.detailCoinScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composermvvm.common.Resource
import com.example.composermvvm.domain.usecase.getCoin.CoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailCoinViewModel @Inject constructor(
    private val getCoinUseCase: CoinDetailsUseCase,
     savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>("coinId")?.let {
            getCoins(it)
        }
    }
    private fun getCoins(coinId: String){
        getCoinUseCase(coinId).onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error ->{
                    _state.value = CoinDetailState(error = result.message ?: "Something went wrong")
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}