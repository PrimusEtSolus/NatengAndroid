package com.natenghub.app

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.navigation.NavigationView

class MyListingsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_listings)

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
            Produce("Cabbage", "500kg", "₱30/kg", "Live", "2023-10-26"),
            Produce("Carrots", "200kg", "₱45/kg", "Negotiating", "2023-10-26"),
            Produce("Potatoes", "1T", "₱50/kg", "Sold", "2023-10-25"),
            Produce("Lettuce", "150kg", "₱60/kg", "Sold", "2023-10-24"),
            Produce("Broccoli", "300kg", "₱80/kg", "Archived", "2023-10-20")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_listings)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProduceAdapter(produceList)

        val listNewHarvestButton = findViewById<MaterialButton>(R.id.btn_list_new_harvest)
        listNewHarvestButton.setOnClickListener {
            val intent = Intent(this, CreateListingActivity::class.java)
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
                // Already on this screen
            }
            R.id.nav_incoming_orders -> {
                val intent = Intent(this, IncomingOrdersActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_transaction_history -> {
                val intent = Intent(this, TransactionHistoryActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
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
}
