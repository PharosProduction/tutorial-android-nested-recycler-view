package com.pharosproduction.androidnestedrecycler

import com.pharosproduction.androidnestedrecycler.data.Ndo
import com.pharosproduction.androidnestedrecycler.data.NestedDataObjectWrapper
import com.pharosproduction.androidnestedrecycler.data.Pdo

object Repository {

    val mok = listOf(
        Pdo(1),
        Pdo(2),
        NestedDataObjectWrapper(
            listOf(Ndo(1), Ndo(2), Ndo(3), Ndo(4), Ndo(5), Ndo(6), Ndo(7))
        ),
        Pdo(4),
        Pdo(5),
        Pdo(6),
        NestedDataObjectWrapper(
            listOf(Ndo(1), Ndo(2), Ndo(3), Ndo(4), Ndo(5), Ndo(6), Ndo(7))
        ),
        Pdo(8),
        Pdo(9),
        Pdo(10),
        Pdo(11),
        Pdo(12),
        Pdo(13),
        NestedDataObjectWrapper(
            listOf(Ndo(1), Ndo(2), Ndo(3), Ndo(4), Ndo(5), Ndo(6), Ndo(7))
        ),
        Pdo(15),
        Pdo(16),
        Pdo(17)
    )
}