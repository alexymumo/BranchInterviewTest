package com.example.branchinterviewtest.ui.screens.messages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.branchinterviewtest.data.models.Messages
import com.example.branchinterviewtest.ui.components.MessageCard
import com.example.branchinterviewtest.ui.navigation.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MessageScreen(navController: NavController, viewModel: MessagesViewModel = hiltViewModel()) {
  val messages by viewModel.messages.collectAsState()
  Scaffold(
    topBar = {
      TopAppBar(title = { 
        Text(text = "Messages")
      })
    }
  ) {
    MessageList(messages = messages, navController = navController)
  }
}

@Composable
fun MessageList(
  messages: List<Messages>,
  navController: NavController
){
  LazyColumn {
    items(messages) { messages ->
      MessageCard(messages = messages, onNavigate = {
        navController.currentBackStackEntry?.savedStateHandle?.set(
          key = "thread_id",
          value = messages
        )
        navController.navigate(NavItem.MessageDetail.route)
      })
    }
  }
}

