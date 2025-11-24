package com.natenghub.app

data class IncomingOrder(
    val orderId: String,
    val items: String,
    val date: String,
    val status: String
)
