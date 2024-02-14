package com.example.branchinterviewtest.data.repository

import android.util.Log
import com.example.branchinterviewtest.data.api.BranchApi
import com.example.branchinterviewtest.data.datastore.BranchPreference
import com.example.branchinterviewtest.data.models.Login
import javax.inject.Inject

class LoginRepository @Inject constructor(private val branchApi: BranchApi, private val branchPreference: BranchPreference) {
  suspend fun login(username: String, password:String):String {
    val reversePassword = password.reversed()
    val login = Login(username, reversePassword)
    val loginResponse = branchApi.login(login)
    val branchToken = loginResponse.authToken
    branchPreference.saveBranchToken(branchToken)
    Log.d("Branch-Token", branchToken)
    return branchToken
  }

}