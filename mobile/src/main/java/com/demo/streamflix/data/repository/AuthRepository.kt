package com.demo.streamflix.data.repository

import com.demo.streamflix.data.model.request.LoginRequest
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val supabaseClient: SupabaseClient
) {

    suspend fun login(loginRequest: LoginRequest): Result<Unit> {
        return runCatching {
            supabaseClient.auth.signInWith(Email) {
                email = loginRequest.email
                password = loginRequest.password
            }
        }
    }

    suspend fun signUp(email: String, password: String): Result<Unit> {
        return runCatching {
            // Na versão atual, signUpWith é usado para registro
            supabaseClient.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
        }
    }

    suspend fun signOut() {
        supabaseClient.auth.signOut()
    }

    fun getCurrentUser() = supabaseClient.auth.currentUserOrNull()

    fun isLoggedIn(): Boolean = supabaseClient.auth.currentUserOrNull() != null

    fun getAccessToken(): String? = supabaseClient.auth.currentSessionOrNull()?.accessToken

    suspend fun validateMembership(token: String): Boolean {
        return isLoggedIn()
    }
}