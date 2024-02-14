package com.example.branchinterviewtest.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
  val navController = rememberNavController()
  Scaffold(
    modifier = Modifier.fillMaxSize()
  ) {paddingValues ->
    Column(
      modifier = Modifier.fillMaxSize().padding(paddingValues)
    ) {
      Navigation(navController = navController)
    }
  }
}