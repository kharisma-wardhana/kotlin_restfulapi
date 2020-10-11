package arlite.kotlinrestfulapi.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Min

data class CreateProductRequest (
  @field:NotBlank
  val id:String?,

  @field:NotBlank
  val name:String?,
  
  @field:NotNull
  @field:Min(value = 1)
  val price:Long?,
  
  @field:NotNull
  @field:Min(value = 0)
  val quantity:Int?
)