package com.example.branchinterviewtest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.branchinterviewtest.data.models.Messages

@Composable
fun MessageCard(messages: Messages, onNavigate: (Messages) ->Unit) {
  ElevatedCard(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .padding(all = 4.dp)
      .clickable {
        onNavigate(messages)
      },
    shape = RoundedCornerShape(10.dp),
    elevation = CardDefaults.cardElevation(
      defaultElevation = 6.dp
    )
  ) {
    Row(
      horizontalArrangement = Arrangement.spacedBy(10.dp),
      modifier = Modifier.padding(4.dp)
    ) {
      Column {
        Text(
          text = "ID",
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = messages.id.toString(),
          fontWeight = FontWeight.Medium,
          fontSize = 16.sp
        )
      }
      Column {
        Text(
          text = "Body",
          color = MaterialTheme.colorScheme.onBackground,
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold
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