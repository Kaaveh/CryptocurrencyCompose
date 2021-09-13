package ir.kaaveh.cryptocurrencycompose.domain.usecase.get_coins

import ir.kaaveh.cryptocurrencycompose.common.Resource
import ir.kaaveh.cryptocurrencycompose.data.remote.dto.toCoin
import ir.kaaveh.cryptocurrencycompose.domain.model.Coin
import ir.kaaveh.cryptocurrencycompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(e))
        }
    }
}