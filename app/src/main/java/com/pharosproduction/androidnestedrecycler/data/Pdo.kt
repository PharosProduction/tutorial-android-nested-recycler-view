package com.pharosproduction.androidnestedrecycler.data

import com.pharosproduction.androidnestedrecycler.Holder

data class Pdo(val value: Int) : HasType {

    override fun getType(): Int {
        return Holder.PARENT.type
    }
}