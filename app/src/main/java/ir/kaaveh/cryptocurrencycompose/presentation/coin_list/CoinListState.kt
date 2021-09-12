package ir.kaaveh.cryptocurrencycompose.presentation.coin_list

import ir.kaaveh.cryptocurrencycompose.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = listOf(),
    val error: String = "",
)
