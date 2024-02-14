package com.example.branchinterviewtest.data.repository

import com.example.branchinterviewtest.data.api.BranchApi
import com.example.branchinterviewtest.data.datastore.BranchPreference
import com.example.branchinterviewtest.data.models.Messages
import javax.inject.Inject

class MessagesRepository @Inject constructor(
  private val branchApi: BranchApi, private val branchPreference: BranchPreference
) {
  suspend fun getMessages(): List<Messages>? {
    val branchToken = branchPreference.getBranchToken()
    return branchToken?.let { branchApi.getMessages(it) }
  }

  suspend fun createMessage() {

  }
}