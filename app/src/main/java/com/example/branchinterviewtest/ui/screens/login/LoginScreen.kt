package com.example.branchinterviewtest.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.branchinterviewtest.ui.navigation.NavItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

  val email = remember { mutableStateOf("") }
  val password =  remember { mutableStateOf("") }
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(6.dp)
  ) {
    Text(
      text = "Welcome Back!",
      style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedTextField(value = email.value, onValueChange = {email.value = it}, modifier = Modifier
      .fillMaxWidth()
      .padding(4.dp),
      singleLine = true,
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Email
      ),
      label = {
        Text(text = "Enter Username")
      }
    )
    Spacer(modifier = Modifier.height(5.dp))
    // Add trailing icon
    OutlinedTextField(value = password.value, onValueChange = {password.value = it}, modifier = Modifier
      .fillMaxWidth()
      .padding(4.dp),
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password
      ),

      label = {
        Text(text = "Enter Password")
      }
      )
    Spacer(modifier = Modifier.height(20.dp))
    Button(
      onClick = {
        viewModel.loginUser(email.value, password.value)
        navController.navigate(NavItem.Messages.route)
      },
      modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
      shape = RoundedCornerShape(8)
    ) {
      Text(
        text = "Sign In",
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

@Preview
@Composable
fun LoginScreenPreview() {
  //LoginScreen()
}