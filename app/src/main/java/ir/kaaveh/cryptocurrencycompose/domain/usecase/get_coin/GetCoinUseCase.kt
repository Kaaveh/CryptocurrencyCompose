package ir.kaaveh.cryptocurrencycompose.domain.usecase.get_coin

import ir.kaaveh.cryptocurrencycompose.common.Resource
import ir.kaaveh.cryptocurrencycompose.domain.model.CoinDetail
import ir.kaaveh.cryptocurrencycompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(e))
        }
    }
}