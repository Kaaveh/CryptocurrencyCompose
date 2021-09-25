package ir.kaaveh.cryptocurrencycompose.domain.repository

import ir.kaaveh.cryptocurrencycompose.domain.model.Coin
import ir.kaaveh.cryptocurrencycompose.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(coinId: String): CoinDetail
}