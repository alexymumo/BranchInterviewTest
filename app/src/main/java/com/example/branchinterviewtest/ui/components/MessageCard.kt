package com.example.branchinterviewtest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.branchinterviewtest.data.models.Messages

@Composable
fun MessageCard(messages: Messages, onNavigate: (Messages) ->Unit) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .height(100.dp)
      .padding(all = 4.dp).clickable {
        onNavigate(messages)
      },
    shape = RoundedCornerShape(10.dp)
  ) {
    Row(
      horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      Column {
        Text(
          text = "ID",
          color = MaterialTheme.colorScheme.onBackground,
          fontSize = 18.sp
        )
        Text(text = messages.id.toString())
      }
      Column {
        Text(
          text = "Body",
          color = MaterialTheme.colorScheme.onBackground,
          fontSize = 18.sp,
        )
        Text(
          text = messages.body,
          maxLines = 3
        )
      }
      /*
      Spacer(modifier = Modifier.height(2.dp))
      Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
          text = "Timestamp",
          color = MaterialTheme.colorScheme.onBackground,
          fontSize = 18.sp
        )
        Text(text =messages.timestamp)
      }*/
    }
  }
}

@Preview
@Composable
fun MessageCardPreview() {
  //MessageCard()
}