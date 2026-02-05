package com.demo.streamflix.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Channel(
    val id: Int,
    val number: Int,
    val name: String,
    val description: String = "",  // Adicione com valor default
    val logo: String = "",
    val url: String,
    val categoryId: Int = 0,
    val isHd: Boolean = false,
    val isFavorite: Boolean = false
) : Parcelable