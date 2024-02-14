package com.example.branchinterviewtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BranchApplication: Application() {
  override fun onCreate() {
    super.onCreate()
  }

}