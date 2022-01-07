package com.shubham.localisationdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import android.widget.Spinner
import com.shubham.localisationdemo.databinding.ActivityMainBinding
import android.app.Activity
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var locale:Locale
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCustomSpinner()
        binding.customSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when(position){
                    1->{
                        setLocale("it")
                    }
                    2->{
                        setLocale("es")
                    }
                    3->{
                        setLocale("de")
                    }
                    4->{
                        setLocale("en")
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Use as per your wish
            }
        }
    }


    private fun setupCustomSpinner() {
        val adapter = CountryArrayAdapter(this, Countries.list!!)
        binding.customSpinner.adapter = adapter

    }

    fun setLocale( languageCode: String) {
        locale = Locale(languageCode)
        var res=resources
        var dm=res.displayMetrics
        var conf=res.configuration
        conf.locale=locale
        res.updateConfiguration(conf,dm)

        var selfIntent=Intent(this,MainActivity::class.java)
        startActivity(selfIntent).also {
            finish()
        }

    }
}