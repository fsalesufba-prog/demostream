package com.demo.streamflix.model.mapper

import com.demo.streamflix.model.Category
import com.demo.streamflix.model.Channel
import com.demo.streamflix.model.User
import com.demo.streamflix.data.local.entity.CategoryEntity
import com.demo.streamflix.data.local.entity.ChannelEntity
import com.demo.streamflix.data.local.entity.UserEntity

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = this.id.toInt(),
        name = this.name,
        logo = this.iconUrl ?: ""
    )
}

fun ChannelEntity.toChannel(): Channel {
    return Channel(
        id = this.id.toInt(),
        number = this.number,
        name = this.name,
        logo = this.logoUrl ?: "",
        url = this.streamUrl ?: "",
        categoryId = this.categoryId.toInt(),
        isHd = this.isHd,
        isFavorite = false
    )
}

fun UserEntity.toUser(): User {
    return User(
        id = this.id.toString(),
        email = this.email ?: "",
        name = this.name ?: "",
        phone = this.phone ?: "",
        membershipActive = this.membershipExpiry != null
    )
}