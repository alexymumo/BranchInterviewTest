package com.example.branchinterviewtest.data.models

import com.google.gson.annotations.SerializedName

data class Message(
  @SerializedName("thread_id")
  val thread_id: Int,
  @SerializedName("body")
  val body: String
)
