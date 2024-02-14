package com.example.branchinterviewtest.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.datastore : DataStore<Preferences> by preferencesDataStore(name = "BRANCH_TEST")
class BranchPreference(
  private val context: Context
) {
  private val BRANCH_TOKEN = stringPreferencesKey("token")
  suspend fun saveBranchToken(branchToken: String) {
    context.datastore.edit {token ->
      token[BRANCH_TOKEN] = branchToken
    }
  }
  suspend fun getBranchToken(): String? {
    return context.datastore.data.first()[BRANCH_TOKEN]
  }
}