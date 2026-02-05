package com.demo.streamflix.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String,
    val email: String? = null,
    val name: String? = null,
    val phone: String? = null,
    val membershipActive: Boolean = false
) : Parcelable
