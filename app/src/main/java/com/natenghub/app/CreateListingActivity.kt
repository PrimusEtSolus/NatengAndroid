package com.natenghub.app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class CreateListingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_listing)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val cropTypes = arrayOf("Cabbage", "Carrots", "Potatoes", "Lettuce", "Broccoli")
        val qualityGrades = arrayOf("Class A", "Class B", "Reject")

        val cropAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cropTypes)
        val qualityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, qualityGrades)

        val cropDropdown = findViewById<AutoCompleteTextView>(R.id.actv_crop_type)
        cropDropdown.setAdapter(cropAdapter)

        val qualityDropdown = findViewById<AutoCompleteTextView>(R.id.actv_quality_grade)
        qualityDropdown.setAdapter(qualityAdapter)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
