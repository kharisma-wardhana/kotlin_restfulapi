package arlite.kotlinrestfulapi.service

import arlite.kotlinrestfulapi.model.CreateProductRequest

interface ProductService {
  fun create(request: CreateProductRequest): ProductResponse
}