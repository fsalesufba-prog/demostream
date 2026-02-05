package com.demo.streamflix.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.streamflix.data.model.request.LoginRequest
import com.demo.streamflix.data.repository.AuthRepository
import com.demo.streamflix.util.SharedPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val sharedPrefs: SharedPrefs
) : ViewModel() {

    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        data class Success(val message: String) : LoginState()
        data class Error(val message: String) : LoginState()
    }

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                // Login deve retornar Unit ou Session, não Result<Unit>
                authRepository.login(loginRequest)

                // Login successful - verificar se usuário está autenticado
                if (authRepository.isLoggedIn()) {
                    sharedPrefs.putBoolean("is_logged_in", true)
                    sharedPrefs.putString("user_email", loginRequest.email)

                    // Save remember me preference
                    sharedPrefs.putBoolean("remember_me", loginRequest.rememberMe)

                    // Get and save user token
                    authRepository.getAccessToken()?.let { token ->
                        sharedPrefs.putString("auth_token", token)
                    }

                    // Get user data
                    authRepository.getCurrentUser()?.let { user ->
                        sharedPrefs.putString("user_id", user.id)
                        sharedPrefs.putString("user_email", user.email ?: "")
                    }

                    _loginState.value = LoginState.Success("Login successful")
                } else {
                    _loginState.value = LoginState.Error("Login failed - user not authenticated")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(
                    e.message ?: "Network error"
                )
            }
        }
    }

    fun resetState() {
        _loginState.value = LoginState.Idle
    }
}