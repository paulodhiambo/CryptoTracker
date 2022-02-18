package com.odhiambopaul.cryptotracker.domain.model

import com.odhiambopaul.cryptotracker.data.remote.dto.*

data class CoinDetail(
    val description: String,
    val id: String,
    val is_active: Boolean,
    val links: Links,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val hashAlgorithm: String,
)