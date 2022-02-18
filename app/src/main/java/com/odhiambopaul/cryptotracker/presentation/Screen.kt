package com.odhiambopaul.cryptotracker.presentation

sealed class Screen(val route: String) {
    object coinListScreen : Screen("coin_list_screen")
    object coinDetailScreen : Screen("coin_detail_screen")
}
