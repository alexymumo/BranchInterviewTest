package com.example.branchinterviewtest.data.repository

import com.example.branchinterviewtest.data.api.BranchApi
import com.example.branchinterviewtest.data.datastore.BranchPreference
import com.example.branchinterviewtest.data.models.Message
import com.example.branchinterviewtest.data.models.Messages
import javax.inject.Inject

class MessagesRepository @Inject constructor(
  private val branchApi: BranchApi, private val branchPreference: BranchPreference
) {
  suspend fun getMessages(): List<Messages>? {
    val branchToken = branchPreference.getBranchToken()
    return branchToken?.let { branchApi.getMessages(it) }
  }

  suspend fun createMessage(threadId: Int, body: String): Messages {
    val branchToken = branchPreference.getBranchToken()
    val message = Message(threadId, body)
    return branchApi.sendMessage(branchToken!!, message)
  }

  suspend fun deleteMessages() {
    val branchToken = branchPreference.getBranchToken()
    return branchApi.deleteMessages(branchToken!!)
  }
}