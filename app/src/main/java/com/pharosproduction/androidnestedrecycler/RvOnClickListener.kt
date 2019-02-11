package com.pharosproduction.androidnestedrecycler

interface RvOnClickListener {

    fun onItmClick(parentPosition: Int, nestedPosition: Int? = null)
}