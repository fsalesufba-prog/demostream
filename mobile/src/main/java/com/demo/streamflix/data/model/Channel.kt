package com.demo.streamflix.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Channel(
    val id: String,
    val name: String,
    val description: String,
    val logo: String,
    val streamUrl: String, // Added streamUrl
    val categoryId: Int,
    val number: Int // Added channel number
) : Parcelable
