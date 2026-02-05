package com.demo.streamflix.repository

import com.demo.streamflix.model.dao.CategoryDao
import com.demo.streamflix.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor(
    private val dao: CategoryDao
) {

    fun getCategories(): Flow<List<CategoryEntity>> = dao.getAll()

    suspend fun save(categories: List<CategoryEntity>) {
        dao.insertAll(categories)
    }

    suspend fun clear() {
        dao.clear()
    }
}
