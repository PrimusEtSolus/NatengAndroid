package com.natenghub.app

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class ConversationDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation_detail)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val messageList = listOf(
            ChatMessage("Hello! I\'m interested in your cabbage listing. Is the 500kg volume still available?", true),
            ChatMessage("Hello! Yes, the 500kg of cabbage is still available and was harvested this morning.", false)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_chat_messages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ChatMessageAdapter(messageList)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
