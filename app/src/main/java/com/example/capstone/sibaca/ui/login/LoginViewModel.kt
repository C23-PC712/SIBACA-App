package com.example.capstone.sibaca.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.sibaca.model.SessionModel
import com.example.capstone.sibaca.model.TTSRepository
import com.example.capstone.sibaca.service.response.LoginResponse
import com.example.capstone.sibaca.utils.Event
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: TTSRepository) : ViewModel() {
    val loginResponse: LiveData<LoginResponse> = repo.loginResponse
    val isLoading: LiveData<Boolean> = repo.isLoading
    val toastText: LiveData<Event<String>> = repo.toastText

    fun postLogin(email: String, password: String) {
        viewModelScope.launch {
            repo.postLogin(email, password)
        }
    }

    fun saveSession(session: SessionModel) {
        viewModelScope.launch {
            repo.saveSession(session)
        }
    }

    fun login() {
        viewModelScope.launch {
            repo.login()
        }
    }
}
