package com.reift.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kisah(
    val usia: String,

    val iconUrl: String,

    val tmp: String,

    val imageUrl: String,

    val name: String,

    val thnKelahiran: String,

    val description: String
): Parcelable
