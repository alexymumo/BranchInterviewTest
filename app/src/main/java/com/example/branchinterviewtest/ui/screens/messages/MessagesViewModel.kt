package com.example.branchinterviewtest.ui.screens.messages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.branchinterviewtest.data.models.Messages
import com.example.branchinterviewtest.data.repository.MessagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessagesViewModel @Inject constructor(private val messagesRepository: MessagesRepository): ViewModel() {
  private val _messages = MutableStateFlow<List<Messages>>(emptyList())
  val messages: StateFlow<List<Messages>> = _messages
  init {
    getMessages()
  }

  private fun getMessages() {
    viewModelScope.launch {
      _messages.value = messagesRepository.getMessages()!!

    }
  }
}