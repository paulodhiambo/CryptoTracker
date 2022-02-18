package com.odhiambopaul.cryptotracker.domain.repository

import com.odhiambopaul.cryptotracker.data.remote.dto.CoinDetailDto
import com.odhiambopaul.cryptotracker.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}