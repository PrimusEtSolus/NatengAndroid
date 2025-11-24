package com.natenghub.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<TextInputEditText>(R.id.et_email)
        val passwordEditText = findViewById<TextInputEditText>(R.id.et_password)
        val loginButton = findViewById<MaterialButton>(R.id.btn_login)
        val signupButton = findViewById<MaterialButton>(R.id.btn_signup)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            when {
                email == "farmer@test.com" && password == "test123" -> {
                    val intent = Intent(this, FarmerDashboardActivity::class.java)
                    startActivity(intent)
                }
                email == "buyer@test.com" && password == "test123" -> {
                    val intent = Intent(this, BuyerMarketplaceActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        signupButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
