package ir.kaaveh.cryptocurrencycompose.presentation.coin_detail

import ir.kaaveh.cryptocurrencycompose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = "",
)
