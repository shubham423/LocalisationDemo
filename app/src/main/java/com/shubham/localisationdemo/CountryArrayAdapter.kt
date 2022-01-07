package com.shubham.localisationdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CountryArrayAdapter(context: Context, countryList: List<Country>) : ArrayAdapter<Country>(context, 0, countryList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {

        val country = getItem(position)

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)
        view.findViewById<ImageView>(R.id.countryImage).setImageResource(country!!.image)
        view.findViewById<TextView>(R.id.countryName).text = country.name

        return view
    }
}