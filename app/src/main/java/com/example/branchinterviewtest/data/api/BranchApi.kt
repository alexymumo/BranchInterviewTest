package com.example.branchinterviewtest.data.api

import com.example.branchinterviewtest.data.models.Login
import com.example.branchinterviewtest.data.models.LoginResponse
import com.example.branchinterviewtest.data.models.Message
import com.example.branchinterviewtest.data.models.Messages
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface BranchApi {
  @Headers("Content-Type: application/json")
  @POST("/api/login")
  suspend fun login(
    @Body login: Login
  ): LoginResponse

  @GET("api/messages")
  suspend fun getMessages(
    @Header("X-Branch-Auth-Token") authToken: String
  ): List<Messages>

  @POST("api/messages")
  suspend fun sendMessage(
    @Header("X-Branch-Auth-Token") authToken: String
  ) : Message

  @POST("api/reset")
  suspend fun deleteMessages(
    @Header("X-Branch-Auth-Token") authToken: String
  )
}