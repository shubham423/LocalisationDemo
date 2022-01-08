package com.shubham.localisationdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import com.shubham.localisationdemo.databinding.ActivityMainBinding
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var locale:Locale
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("pos",0)
        Log.d("Main", "onCreate: $position")
        setupCustomSpinner()


        binding.customSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                binding.customSpinner.setSelection(position)

                when(position){
                    1->{
                        setLocale("it",position)
                    }
                    2->{
                        setLocale("es",position)
                    }
                    3->{
                        setLocale("de",position)
                    }
                    4->{
                        setLocale("en",position)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Use as per your wish
            }
        }

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (binding.switch1.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.jokesHeadingTv.setTextColor(resources.getColor(R.color.white))
                binding.switch1.text = "Disable dark mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.switch1.text = "Enable dark mode"
            }
        }
    }


    private fun setupCustomSpinner() {
        val adapter = CountryArrayAdapter(this, Countries.list!!)
        binding.customSpinner.adapter = adapter

    }

    fun setLocale(languageCode: String, position: Int) {
        locale = Locale(languageCode)
        var res=resources
        var dm=res.displayMetrics
        var conf=res.configuration
        conf.locale=locale
        res.updateConfiguration(conf,dm)

        var selfIntent=Intent(this,MainActivity::class.java)
        selfIntent.putExtra("pos",position)
        startActivity(selfIntent)

    }
}