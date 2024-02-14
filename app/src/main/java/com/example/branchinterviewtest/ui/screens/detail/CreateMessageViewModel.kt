package com.example.branchinterviewtest.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.branchinterviewtest.data.repository.MessagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateMessageViewModel @Inject constructor(private val messagesRepository: MessagesRepository): ViewModel() {
  fun createMessage(threadId: Int, body: String) {
    viewModelScope.launch {
      messagesRepository.createMessage(threadId, body)
    }
  }
}