package com.example.branchinterviewtest.ui.navigation

sealed class NavItem(val route: String, val title: String) {
  object Login: NavItem("login", "Login")
  object Messages: NavItem("messages", "Messages")
  object MessageDetail: NavItem("message_detail", "Detail")

}