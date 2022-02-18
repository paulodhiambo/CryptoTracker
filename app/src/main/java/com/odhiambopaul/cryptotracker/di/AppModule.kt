package com.odhiambopaul.cryptotracker.di

import com.odhiambopaul.cryptotracker.common.Constants.BASE_URL
import com.odhiambopaul.cryptotracker.data.remote.CoinCaprikaAPI
import com.odhiambopaul.cryptotracker.data.repository.CoinRepositoryImpl
import com.odhiambopaul.cryptotracker.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePapfrikaAPI(): CoinCaprikaAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinCaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinCaprikaAPI): CoinRepository {
        return CoinRepositoryImpl(api = api)

    }
}