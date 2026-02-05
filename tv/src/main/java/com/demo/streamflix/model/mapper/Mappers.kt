package com.demo.streamflix.model.mapper

import com.demo.streamflix.model.Category
import com.demo.streamflix.model.Channel
import com.demo.streamflix.model.entity.CategoryEntity
import com.demo.streamflix.model.entity.ChannelEntity

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = this.id,
        name = this.name,
        logo = this.logo
    )
}

fun ChannelEntity.toChannel(): Channel {
    return Channel(
        id = this.id,
        name = this.name,
        description = this.description,
        logo = this.logo,
        categoryId = this.categoryId
    )
}
