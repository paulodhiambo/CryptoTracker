package com.odhiambopaul.cryptotracker.data.remote

import com.odhiambopaul.cryptotracker.data.remote.dto.CoinDetailDto
import com.odhiambopaul.cryptotracker.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinCaprikaAPI {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId") coinId: String): CoinDetailDto
}