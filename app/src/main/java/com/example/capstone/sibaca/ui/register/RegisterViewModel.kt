package com.example.capstone.sibaca.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstone.sibaca.model.TTSRepository
import com.example.capstone.sibaca.service.response.RegisterResponse
import com.example.capstone.sibaca.utils.Event
import kotlinx.coroutines.launch

class RegisterViewModel(private val repo: TTSRepository) : ViewModel() {
    val registerResponse: LiveData<RegisterResponse> = repo.registerResponse
    val isLoading: LiveData<Boolean> = repo.isLoading
    val toastText: LiveData<Event<String>> = repo.toastText

    fun postRegister(name: String, email: String, password: String) {
        viewModelScope.launch {
            repo.postRegister(name, email, password)
        }
    }
}
