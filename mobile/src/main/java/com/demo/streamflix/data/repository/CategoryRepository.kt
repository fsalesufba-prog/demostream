package com.demo.streamflix.data.repository

import com.demo.streamflix.model.entity.CategoryEntity
import io.github.jan_tennert.supabase.SupabaseClient
import io.github.jan_tennert.supabase.postgrest.from
import io.github.jan_tennert.supabase.postgrest.query.Columns
import io.github.jan_tennert.supabase.postgrest.query.Count
import io.github.jan_tennert.supabase.postgrest.query.Order
import io.github.jan_tennert.supabase.postgrest.request.FilterOperation
import io.github.jan_tennert.supabase.postgrest.request.FilterOperator

class CategoryRepository(private val supabaseClient: SupabaseClient) {

    suspend fun getAllCategories(): List<CategoryEntity> {
        return supabaseClient.from("categories").select().decodeList<CategoryEntity>()
    }

    // Add other category-related Supabase functions here
}
