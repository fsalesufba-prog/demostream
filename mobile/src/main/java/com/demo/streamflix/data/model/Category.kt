package com.demo.streamflix.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Long,
    val name: String,
    val description: String? = null,
    val iconUrl: String? = null,
    val channelCount: Int = 0
) : Parcelable