package com.odhiambopaul.cryptotracker.presentation.ui.coinlist

import com.odhiambopaul.cryptotracker.domain.model.Coin

data class CoinListState(
    var isLoading: Boolean = false,
    var coins: List<Coin> = emptyList(),
    var error: String = ""
)