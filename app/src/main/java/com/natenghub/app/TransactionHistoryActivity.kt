package com.natenghub.app

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class TransactionHistoryActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_history)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val userType = intent.getStringExtra("user_type")
        val transactionList = if (userType == "farmer") {
            navigationView.menu.clear()
            navigationView.inflateMenu(R.menu.farmer_nav_menu)
            listOf(
                Transaction("ORD001", "2023-10-25", "+ ₱50,000.00", "Completed"),
                Transaction("ORD003", "2023-10-22", "+ ₱18,000.00", "Completed")
            )
        } else {
            navigationView.menu.clear()
            navigationView.inflateMenu(R.menu.buyer_nav_menu)
            listOf(
                Transaction("ORD001", "2023-10-25", "- ₱50,000.00", "Delivered"),
                Transaction("ORD002", "2023-10-26", "- ₱15,000.00", "Shipped"),
                Transaction("ORD003", "2023-10-22", "- ₱18,000.00", "Delivered"),
                Transaction("ORD004", "2023-10-27", "- ₱9,000.00", "Processing")
            )
        }

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val recyclerView = findViewById<RecyclerView>(R.id.rv_transactions)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TransactionAdapter(transactionList)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    finish()
                }
            }
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_dashboard -> {
                val intent = Intent(this, FarmerDashboardActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_my_listings -> {
                val intent = Intent(this, MyListingsActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_incoming_orders -> {
                val intent = Intent(this, IncomingOrdersActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_transaction_history -> {
                // Already on this screen
            }
            R.id.nav_marketplace -> {
                val intent = Intent(this, BuyerMarketplaceActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_my_orders -> {
                val intent = Intent(this, MyOrdersActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                intent.putExtra("user_type", getIntent().getStringExtra("user_type"))
                startActivity(intent)
            }
            else -> {
                Toast.makeText(this, "Coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
