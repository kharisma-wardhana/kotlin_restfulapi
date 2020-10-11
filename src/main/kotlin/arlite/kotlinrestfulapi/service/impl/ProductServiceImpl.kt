package arlite.kotlinrestfulapi.service.impl

import org.springframework.stereotype.Service
import arlite.kotlinrestfulapi.service.ProductService
import arlite.kotlinrestfulapi.repository.ProductRepo
import arlite.kotlinrestfulapi.entity.Product
import java.util.*

@Service
class ProductServiceImpl(val productRepo: ProductRepo) : ProductService{
  override fun create(request: CreateProductRequest): ProductResponse {
    val product = Product(
      id = request.id,
      name = request.name,
      price= request.price,
      quantity = request.quantity
      createdAt = Date(),
      updatedAt = Date()
    )
    productRepo.save(product)

    return ProductResponse(
      id = product.id,
      name = product.name,
      price= product.price,
      quantity = product.quantity
      createdAt = product.createdAt,
      updatedAt = product.updatedAt
    )
  }
}