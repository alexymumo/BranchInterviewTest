package com.example.branchinterviewtest.ui.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.branchinterviewtest.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository): ViewModel() {
  fun loginUser(username: String, password: String) {
    viewModelScope.launch(Dispatchers.IO) {
      val response = loginRepository.login(username, password)
      if (response.equals(null)) {
        Log.d("Failed to save", "Saved")
      }
    }
  }
}