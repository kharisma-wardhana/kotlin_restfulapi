package arlite.kotlinrestfulapi.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import arlite.kotlinrestfulapi.service.ProductService
import arlite.kotlinrestfulapi.model.CreateProductRequest
import arlite.kotlinrestfulapi.model.Response
import arlite.kotlinrestfulapi.model.ProductResponse

@RestController
class ProductController(val productService:ProductService) {

  @PostMapping(
    value = ["/api/products"],
    produces = ["application/json"],
    consumes = ["application/json"]
  )
  fun createProduct(@RequestBody request: CreateProductRequest):Response<ProductResponse>{
    val res = productService.create(request)
    return Response(
      code = 200,
      status = "success",
      data = res,
      message = "product created successfully"
    )
  }
}