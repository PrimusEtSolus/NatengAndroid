package com.natenghub.app

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.navigation.NavigationView

class SettingsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val userType = intent.getStringExtra("user_type")
        if (userType == "farmer") {
            navigationView.menu.clear()
            navigationView.inflateMenu(R.menu.farmer_nav_menu)
        } else {
            navigationView.menu.clear()
            navigationView.inflateMenu(R.menu.buyer_nav_menu)
        }

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val logoutButton = findViewById<MaterialButton>(R.id.btn_logout)
        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
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
                val intent = Intent(this, TransactionHistoryActivity::class.java)
                startActivity(intent)
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
                // Already on this screen
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
}
