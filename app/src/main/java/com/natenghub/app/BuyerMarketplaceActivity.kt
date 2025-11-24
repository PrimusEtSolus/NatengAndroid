package com.natenghub.app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.card.MaterialCardView
import com.google.android.material.navigation.NavigationView

class BuyerMarketplaceActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buyer_marketplace)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val produceList = listOf(
            MarketplaceProduce("Fresh Cabbage", "by Juan Dela Cruz", "₱30.00 /kg", "500 kg available", "Harvested Today @ 6:00 AM", "La Trinidad, Benguet", true, ""),
            MarketplaceProduce("Organic Carrots", "by Maria Clara", "₱45.00 /kg", "200 kg available", "Pre-Order, Harvesting on 11/26/2025", "Atok, Benguet", true, ""),
            MarketplaceProduce("Class A Potatoes", "by Crisostomo Ibarra", "₱50.00 /kg", "1000 kg available", "Harvested Yesterday @ 5:00 PM", "Buguias, Benguet", true, "")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_marketplace_produce)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = MarketplaceProduceAdapter(produceList)

        val postRequestCard = findViewById<MaterialCardView>(R.id.post_buying_request_card)
        postRequestCard.setOnClickListener {
            val intent = Intent(this, PostRequestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_marketplace -> {
                // Already on this screen
            }
            R.id.nav_my_orders -> {
                val intent = Intent(this, MyOrdersActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_transaction_history -> {
                val intent = Intent(this, TransactionHistoryActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                intent.putExtra("user_type", "buyer")
                startActivity(intent)
            }
            else -> {
                Toast.makeText(this, "Coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.farmer_dashboard_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_notifications -> {
                Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
