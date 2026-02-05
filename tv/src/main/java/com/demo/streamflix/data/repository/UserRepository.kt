package com.demo.streamflix.data.repository

import com.demo.streamflix.model.entity.UserEntity
import io.github.jan_tennert.supabase.SupabaseClient
import io.github.jan_tennert.supabase.postgrest.from
import io.github.jan_tennert.supabase.postgrest.query.Columns
import io.github.jan_tennert.supabase.postgrest.query.Count
import io.github.jan_tennert.supabase.postgrest.query.Order
import io.github.jan_tennert.supabase.postgrest.request.FilterOperation
import io.github.jan_tennert.supabase.postgrest.request.FilterOperator

class UserRepository(private val supabaseClient: SupabaseClient) {

    suspend fun getUserById(userId: String): UserEntity? {
        return supabaseClient.from("users").select {
            filter {
                eq("id", userId)
            }
        }.decodeSingleOrNull<UserEntity>()
    }

    // Add other user-related Supabase functions here
}
