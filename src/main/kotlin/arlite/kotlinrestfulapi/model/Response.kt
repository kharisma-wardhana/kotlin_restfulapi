package arlite.kotlinrestfulapi.model

data class Response<T> (
  val code: Int,
  val status: String,
  val data: T,
  val message: String
)