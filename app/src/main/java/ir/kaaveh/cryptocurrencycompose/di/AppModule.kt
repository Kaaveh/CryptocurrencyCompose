package ir.kaaveh.cryptocurrencycompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.kaaveh.cryptocurrencycompose.common.Constants.BASE_URL
import ir.kaaveh.cryptocurrencycompose.data.remote.CoinPaprikaAPI
import ir.kaaveh.cryptocurrencycompose.data.repository.CoinRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaAPI() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI) =
        CoinRepositoryImpl(api)
}