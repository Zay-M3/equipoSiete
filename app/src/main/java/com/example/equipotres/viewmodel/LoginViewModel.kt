package com.example.equipotres.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _authenticationStatus = MutableLiveData<AuthenticationState>()
    val authenticationStatus: LiveData<AuthenticationState> = _authenticationStatus

    fun onAuthenticationSuccess() {
        _authenticationStatus.value = AuthenticationState.Success
    }

    fun onAuthenticationError(errorMessage: String) {
        _authenticationStatus.value = AuthenticationState.Error(errorMessage)
    }

    fun onAuthenticationFailed() {
        _authenticationStatus.value = AuthenticationState.Failed
    }

    fun resetAuthenticationState() {
        _authenticationStatus.value = AuthenticationState.Idle
    }
}

sealed class AuthenticationState {
    object Idle : AuthenticationState()
    object Success : AuthenticationState()
    object Failed : AuthenticationState()
    data class Error(val message: String) : AuthenticationState()
}