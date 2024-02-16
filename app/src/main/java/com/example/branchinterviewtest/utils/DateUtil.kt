package com.example.branchinterviewtest.utils

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtil {
  fun convertDate(timeStamp: String): String {
    val dateInput = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val dateOutput = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val finalDate = dateInput.parse(timeStamp)
    return dateOutput.format(finalDate!!)
  }
}