package com.example.branchinterviewtest.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.branchinterviewtest.data.models.Messages

@Composable
fun MessageDetailScreen(navController: NavController, messages: Messages) {
  Column(
    modifier = Modifier.fillMaxSize()
  ) {

  }
}


@Preview
@Composable
fun MessageDetailScreenPreview() {
  //MessageDetailScreen()
}