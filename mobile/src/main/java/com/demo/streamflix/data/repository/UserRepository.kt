package com.demo.streamflix.data.repository

import com.demo.streamflix.data.local.entity.UserEntity
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val supabaseClient: SupabaseClient) {

    suspend fun getUserById(userId: String): UserEntity? {
        // Método 1: Buscar todos e filtrar localmente (GARANTIDO)
        val allUsers = getAllUsers()
        return allUsers.find { it.id == userId }
    }

    suspend fun getUserByEmail(email: String): UserEntity? {
        val allUsers = getAllUsers()
        return allUsers.find { it.email == email }
    }

    private suspend fun getAllUsers(): List<UserEntity> {
        return try {
            // Tenta usar a sintaxe correta do seu SDK
            supabaseClient.from("users").select().decodeList<UserEntity>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}