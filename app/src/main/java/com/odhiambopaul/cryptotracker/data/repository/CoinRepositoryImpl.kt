package com.odhiambopaul.cryptotracker.data.repository

import com.odhiambopaul.cryptotracker.data.remote.CoinCaprikaAPI
import com.odhiambopaul.cryptotracker.data.remote.dto.CoinDetailDto
import com.odhiambopaul.cryptotracker.data.remote.dto.CoinDto
import com.odhiambopaul.cryptotracker.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinCaprikaAPI) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinDetail(coinId)
    }
}