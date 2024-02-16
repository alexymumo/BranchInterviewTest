package com.example.branchinterviewtest.utils

sealed class Resource<out T>  {
  data class Failure(val message: String): Resource<Nothing>()
  data class Success<out T>(val data: T): Resource<T>()
}