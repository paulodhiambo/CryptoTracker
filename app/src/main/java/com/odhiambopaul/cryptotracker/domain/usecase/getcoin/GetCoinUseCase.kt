package com.odhiambopaul.cryptotracker.domain.usecase.getcoin

import com.odhiambopaul.cryptotracker.common.Resource
import com.odhiambopaul.cryptotracker.data.remote.dto.toCoinDetail
import com.odhiambopaul.cryptotracker.domain.model.CoinDetail
import com.odhiambopaul.cryptotracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "No internet connection"))
        }
    }
}