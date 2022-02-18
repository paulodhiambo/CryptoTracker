package com.odhiambopaul.cryptotracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.odhiambopaul.cryptotracker.presentation.theme.CryptoTrackerTheme
import com.odhiambopaul.cryptotracker.presentation.ui.coindetail.CoinDetailScreen
import com.odhiambopaul.cryptotracker.presentation.ui.coinlist.CoinListScreen
import com.odhiambopaul.cryptotracker.presentation.ui.coinlist.components.CoinListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.coinListScreen.route
                    ) {
                        composable(route = Screen.coinListScreen.route) {
                            CoinListScreen(navController)
                        }

                        composable(route = Screen.coinDetailScreen.route + "/{coinId}") {
                            CoinDetailScreen()
                        }
                    }

                }
            }
        }
    }
}