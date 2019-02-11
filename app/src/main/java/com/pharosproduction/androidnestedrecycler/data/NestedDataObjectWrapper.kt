package com.pharosproduction.androidnestedrecycler.data

import com.pharosproduction.androidnestedrecycler.Holder

class NestedDataObjectWrapper(val nestedDataObjectList: List<Ndo>) : HasType {

    override fun getType(): Int {
        return Holder.NESTED.type
    }
}