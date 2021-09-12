package ir.kaaveh.cryptocurrencycompose.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.kaaveh.cryptocurrencycompose.common.Resource
import ir.kaaveh.cryptocurrencycompose.domain.usecase.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() = getCoinsUseCase().onEach { result ->
        when (result) {
            is Resource.Success -> {
                _state.value = CoinListState(coins = result.data ?: listOf())
            }
            is Resource.Error -> {
                _state.value = CoinListState(
                    error = result.exception?.localizedMessage ?: "An unexpected error occurd."
                )
            }
            is Resource.Loading -> {
                _state.value = CoinListState(isLoading = true)
            }
        }
    }.launchIn(viewModelScope)
}