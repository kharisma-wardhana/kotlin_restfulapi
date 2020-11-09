package arlite.kotlinrestfulapi.controller

import org.springframework.web.bind.annotation.*
import arlite.kotlinrestfulapi.model.*
import arlite.kotlinrestfulapi.service.ProductService

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

  @GetMapping(
    value = ["/api/products/{idProduct}"],
    produces=["application/json"]
  )
  fun getProduct(@PathVariable("idProduct") id: String):Response<ProductResponse>{
    val res = productService.get(id)
    return Response(
      code = 200,
      status = "success",
      data = res,
      message = "successfully get product id "+id
    )
  }

  @GetMapping(
            value = ["/api/products"],
            produces = ["application/json"]
    )
  fun listProducts(@RequestParam(value = "size", defaultValue = "10") size: Int,
                    @RequestParam(value = "page", defaultValue = "0") page: Int): Response<List<ProductResponse>> {
    val request = ListProductRequest(page = page, size = size)
    val responses = productService.list(request)
    return Response(
      code = 200,
      status = "success",
      data = responses,
      message = "success get product list"
    )
  }
}