package ir.kaaveh.cryptocurrencycompose.data.repository

import ir.kaaveh.cryptocurrencycompose.data.remote.CoinPaprikaAPI
import ir.kaaveh.cryptocurrencycompose.data.remote.dto.toCoin
import ir.kaaveh.cryptocurrencycompose.data.remote.dto.toCoinDetail
import ir.kaaveh.cryptocurrencycompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI,
) : CoinRepository {
    override suspend fun getCoins() = api.getCoins().map { it.toCoin() }

    override suspend fun getCoinById(coinId: String) = api.getCoinById(coinId).toCoinDetail()
}