package com.example.branchinterviewtest.data.models

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Messages(
  @SerializedName("id")
  val id: Int,
  @SerializedName("thread_id")
  val thread_id: Int,
  @SerializedName("user_id")
  val user_id: Int,
  @SerializedName("agent_id")
  val agent_id: Int?,
  @SerializedName("body")
  val body: String,
  @SerializedName("timestamp")
  val timestamp: String
): Parcelable
