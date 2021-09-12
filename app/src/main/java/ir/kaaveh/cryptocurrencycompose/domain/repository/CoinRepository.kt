package ir.kaaveh.cryptocurrencycompose.domain.repository

import ir.kaaveh.cryptocurrencycompose.data.remote.dto.CoinDetailDTO
import ir.kaaveh.cryptocurrencycompose.data.remote.dto.CoinDTO

interface CoinRepository {
    suspend fun getCoins(): List<CoinDTO>
    suspend fun getCoinById(coinId: String): CoinDetailDTO
}