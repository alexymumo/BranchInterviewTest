package com.example.branchinterviewtest.data.models

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)

data class LoginResponse(
    @SerializedName("auth_token")
    val authToken: String
)