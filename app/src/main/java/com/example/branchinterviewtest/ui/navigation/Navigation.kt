package com.example.branchinterviewtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.branchinterviewtest.data.models.Messages
import com.example.branchinterviewtest.ui.screens.login.LoginScreen
import com.example.branchinterviewtest.ui.screens.detail.MessageDetailScreen
import com.example.branchinterviewtest.ui.screens.messages.MessageScreen

@Composable
fun Navigation(navController: NavHostController) {
  NavHost(navController = navController, startDestination = NavItem.Login.route) {
    composable(NavItem.Login.route) {
      LoginScreen(navController = navController)

    }
    composable(NavItem.Messages.route) {
      MessageScreen(navController = navController)
    }

    composable(NavItem.MessageDetail.route) {
      val message = navController.previousBackStackEntry?.savedStateHandle?.get<Messages>("thread_id")
      message?.let { messages ->
        MessageDetailScreen(navController = navController, messages = message)
      }
    }
  }
}