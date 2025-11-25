package com.natenghub.app

data class Conversation(
    val name: String,
    val lastMessage: String,
    val unreadCount: Int
)
