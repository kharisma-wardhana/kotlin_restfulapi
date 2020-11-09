package arlite.kotlinrestfulapi.service

import arlite.kotlinrestfulapi.model.*

interface ProductService {
  fun create(request: CreateProductRequest): ProductResponse
  
  fun get(id: String): ProductResponse

  fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}