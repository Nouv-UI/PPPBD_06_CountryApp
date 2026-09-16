package com.example.countryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.countryapp.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var provinces: Array<String>

    private val countries = arrayOf(
        "Indonesia",
        "United States",
        "United Kingdom",
        "Germany",
        "France",
        "Australia",
        "Japan",
        "China",
        "Brazil",
        "Canada"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        provinces = resources.getStringArray(R.array.provinces)

        with(binding) {

            val adapterCountry = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_item,
                countries
            )

            adapterCountry.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )

            spinnerCountry.adapter = adapterCountry

            val adapterProvinces = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_item,
                provinces
            )

            adapterProvinces.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )

            spinnerProvinces.adapter = adapterProvinces
        }
    }
}