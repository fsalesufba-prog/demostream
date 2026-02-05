package com.demo.streamflix.data.model.request

data class LoginRequest(
    val email: String,
    val password: String,
    val rememberMe: Boolean = false // Adicione este campo se não existir
)