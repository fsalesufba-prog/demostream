package com.demo.streamflix.data.repository

import com.demo.streamflix.model.entity.ChannelEntity
import io.github.jan_tennert.supabase.SupabaseClient
import io.github.jan_tennert.supabase.postgrest.from
import io.github.jan_tennert.supabase.postgrest.query.Columns
import io.github.jan_tennert.supabase.postgrest.query.Count
import io.github.jan_tennert.supabase.postgrest.query.Order
import io.github.jan_tennert.supabase.postgrest.request.FilterOperation
import io.github.jan_tennert.supabase.postgrest.request.FilterOperator

class ChannelRepository(private val supabaseClient: SupabaseClient) {

    suspend fun getChannelsForCategory(categoryId: Long): List<ChannelEntity> {
        return supabaseClient.from("channels").select {
            filter {
                eq("category_id", categoryId)
            }
        }.decodeList<ChannelEntity>()
    }

    // Add other channel-related Supabase functions here
}
