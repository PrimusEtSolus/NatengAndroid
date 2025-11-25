package com.natenghub.app

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class NotificationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val userType = intent.getStringExtra("user_type")
        val notificationList = if (userType == "farmer") {
            listOf(
                Notification("New Order Received", "You have a new order for 100kg of Cabbage from Buyer Corp.", "5 minutes ago"),
                Notification("Payment Received", "You have received a payment of ₱50,000.00 for order ORD001.", "1 hour ago"),
                Notification("Listing Expiring Soon", "Your listing for 200kg of Carrots will expire in 3 days.", "2 hours ago")
            )
        } else {
            listOf(
                Notification("Order Shipped", "Your order for 100kg of Cabbage has been shipped.", "10 minutes ago"),
                Notification("New Listing from Juan Dela Cruz", "Juan Dela Cruz has listed a new harvest of 500kg of Fresh Cabbage.", "30 minutes ago"),
                Notification("Price Drop Alert", "The price of Organic Carrots has dropped to ₱40/kg.", "1 day ago")
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_notifications)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotificationAdapter(notificationList)

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
