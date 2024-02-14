package com.example.branchinterviewtest.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.branchinterviewtest.ui.navigation.MainNavigation
import com.example.branchinterviewtest.ui.theme.BranchInterviewTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BranchInterviewTestTheme {
        MainNavigation()
      }
    }
  }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  BranchInterviewTestTheme {

  }
}