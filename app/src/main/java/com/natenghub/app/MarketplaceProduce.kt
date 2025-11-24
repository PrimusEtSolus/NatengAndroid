package com.natenghub.app

data class MarketplaceProduce(
    val name: String,
    val farmerName: String,
    val price: String,
    val availableVolume: String,
    val harvestDate: String,
    val location: String,
    val isVerified: Boolean,
    val imageUrl: String // For now, we'll use a placeholder
)
