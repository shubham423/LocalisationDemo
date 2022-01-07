package com.shubham.localisationdemo

data class Country(val image: Int, val name: String)

object Countries {

    private val images = intArrayOf(
        R.drawable.translation,
        R.drawable.italy,
        R.drawable.spain,
        R.drawable.germany,
        R.drawable.unitedk

    )

    private val countries = arrayOf(
        "Select your language",
        "Italian",
        "Spanish",
        "German",
        "English"
    )

    var list: ArrayList<Country>? = null
        get() {

            if (field != null)
                return field

            field = ArrayList()
            for (i in images.indices) {

                val imageId = images[i]
                val countryName = countries[i]

                val country = Country(imageId, countryName)
                field!!.add(country)
            }

            return field
        }
}