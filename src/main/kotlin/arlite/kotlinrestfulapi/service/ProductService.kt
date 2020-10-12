package arlite.kotlinrestfulapi.service

import arlite.kotlinrestfulapi.model.CreateProductRequest
import arlite.kotlinrestfulapi.model.ProductResponse

interface ProductService {
  fun create(request: CreateProductRequest): ProductResponse
}