package com.example.composermvvm.presentation.coinListScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composermvvm.common.Resource
import com.example.composermvvm.domain.usecase.getCoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getUseCase: GetCoinsUseCase
): ViewModel() {

    private val _state = mutableStateOf(CoinState())
    val state: State<CoinState> = _state

    init {
        getCoins()
    }
    private fun getCoins(){
        getUseCase().onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = CoinState(coins = result.data ?: emptyList())
                }
                is Resource.Error ->{
                    _state.value = CoinState(error = result.message ?: "Something went wrong")
                }
                is Resource.Loading ->{
                    _state.value = CoinState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}