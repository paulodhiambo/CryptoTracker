package com.odhiambopaul.cryptotracker.presentation.ui.coindetail

import com.odhiambopaul.cryptotracker.domain.model.CoinDetail

data class CoinDetailState(
    var isLoading: Boolean = false,
    var coin: CoinDetail? = null,
    var error: String = ""
)
