package ir.kaaveh.cryptocurrencycompose.data.repository

import ir.kaaveh.cryptocurrencycompose.data.remote.CoinPaprikaAPI
import ir.kaaveh.cryptocurrencycompose.data.remote.dto.CoinDTO
import ir.kaaveh.cryptocurrencycompose.data.remote.dto.CoinDetailDTO
import ir.kaaveh.cryptocurrencycompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI,
) : CoinRepository {
    override suspend fun getCoins() = api.getCoins()

    override suspend fun getCoinById(coinId: String) = api.getCoinById(coinId)
}