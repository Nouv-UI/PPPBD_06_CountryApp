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

class MainActivity :
    AppCompatActivity() {

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

        binding.btnShowCalendar.setOnClickListener {

            val datePicker = DatePicker()

            datePicker.show(
                supportFragmentManager,
                "datePicker"
            )

        }


//calendar
        binding.datePicker.init(
            binding.datePicker.year,
            binding.datePicker.month,
            binding.datePicker.dayOfMonth
        ) { _, year, monthOfYear, dayOfMonth ->

            val selectedDate =
                "$dayOfMonth/${monthOfYear + 1}/$year"

            Toast.makeText(
                this@MainActivity,
                selectedDate,
                Toast.LENGTH_SHORT
            ).show()
        }
//time picker
        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->

            val selectedTime =
                String.format("%02d:%02d", hourOfDay, minute)

            Toast.makeText(
                this@MainActivity,
                selectedTime,
                Toast.LENGTH_SHORT
            ).show()
        }

//        spinner
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

            spinnerCountry.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {

                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View,
                        position: Int,
                        id: Long
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            countries[position],
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Tidak ada item yang dipilih
                    }
                }
        }
    }
}