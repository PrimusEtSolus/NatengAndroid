package com.natenghub.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val userType = intent.getStringExtra("user_type")
        val conversationList = if (userType == "farmer") {
            listOf(
                Conversation("Buyer Corp", "Great, we\'ll take the whole lot...", 1),
                Conversation("Maria Clara", "Can you do ₱40/kg for the carrots?", 0)
            )
        } else {
            listOf(
                Conversation("Juan Dela Cruz", "Great, we\'ll take the whole lot...", 1),
                Conversation("Maria Clara", "Can you do ₱40/kg for the carrots?", 0)
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_conversations)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ConversationAdapter(conversationList)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
