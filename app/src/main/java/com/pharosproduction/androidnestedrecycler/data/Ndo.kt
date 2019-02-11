package com.pharosproduction.androidnestedrecycler.data

import com.pharosproduction.androidnestedrecycler.Holder

class Ndo(val value: Int) : HasType {

    override fun getType(): Int {
        return Holder.NESTED.type;
    }
}