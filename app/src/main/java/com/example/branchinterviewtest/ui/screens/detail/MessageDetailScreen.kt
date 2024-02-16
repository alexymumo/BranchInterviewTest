package com.example.branchinterviewtest.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.branchinterviewtest.data.models.Messages

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageDetailScreen(navController: NavController, messages: Messages, viewModel: CreateMessageViewModel = hiltViewModel()) {
  val messageBody = remember  { mutableStateOf("") }
  Column(
    modifier = Modifier.fillMaxSize()
  ) {
    Card(
      modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(4.dp),
      shape = RoundedCornerShape(8.dp)
    ) {
      Text(
        text = "ID ${messages.id}",
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.secondary,
        maxLines = 1,
        fontWeight = FontWeight.Bold
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = messages.body,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 18.sp
      )

      Spacer(modifier = Modifier.height(4.dp))
      Row(
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = "Thread ID ${messages.thread_id}",
          fontWeight = FontWeight.Bold
        )
        Text(text = "Agent ID ${messages.agent_id}")
      }
    }
    Spacer(modifier = Modifier.height(4.dp))
    OutlinedTextField(value = messageBody.value, onValueChange = {messageBody.value = it}, modifier = Modifier
      .fillMaxWidth()
      .padding(4.dp),
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text
      ),
      singleLine = true,
      label = {
        Text(text = "Enter Message")
      }
    )
    Spacer(modifier = Modifier.height(4.dp))
    Button(onClick = {
      viewModel.createMessage(messages.thread_id, messageBody.value)
    }) {
      Text(text = "Reply")
    }
  }
}


@Preview
@Composable
fun MessageDetailScreenPreview() {
  //MessageDetailScreen()
}