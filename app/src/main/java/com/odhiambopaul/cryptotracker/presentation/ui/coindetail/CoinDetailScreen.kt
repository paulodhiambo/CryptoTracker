package com.odhiambopaul.cryptotracker.presentation.ui.coindetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.odhiambopaul.cryptotracker.data.remote.dto.TeamMember
import com.odhiambopaul.cryptotracker.presentation.ui.coindetail.components.CoinTag
import com.odhiambopaul.cryptotracker.presentation.ui.coindetail.components.TeamListItem

@Composable
fun CoinDetailScreen(
    coinListViewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = coinListViewModel.state.value
    Scaffold(
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                state.coin?.let { coin ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(20.dp)
                    ) {
                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = " ${coin.name} (${coin.symbol})",
                                    style = MaterialTheme.typography.h5,
                                    modifier = Modifier.weight(8f)
                                )

                                Text(
                                    text = if (coin.is_active) "active" else "inactive",
                                    color = if (coin.is_active) Color.Green else Color.Red,
                                    fontStyle = FontStyle.Italic,
                                    textAlign = TextAlign.End,
                                    style = MaterialTheme.typography.body2,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .weight(2f)
                                )

                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(text = coin.description, style = MaterialTheme.typography.body2)
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Hashing algorithm", style = MaterialTheme.typography.h5)
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(text = coin.hashAlgorithm, color = Color.Green)
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(text = "Tags", style = MaterialTheme.typography.h5)
                            Spacer(modifier = Modifier.height(15.dp))
                            FlowRow(
                                mainAxisSpacing = 10.dp,
                                crossAxisSpacing = 10.dp,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                coin.tags.forEach { tag ->
                                    CoinTag(tag = tag.name)
                                }
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(text = "Team members", style = MaterialTheme.typography.h5)
                            Spacer(modifier = Modifier.height(15.dp))


                        }
                        items(coin.team) { member: TeamMember ->
                            TeamListItem(
                                teamMember = member,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            )
                        }
                    }
                }
                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                    Divider()
                }

                if (state.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    )

}