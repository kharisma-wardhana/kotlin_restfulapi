package arlite.kotlinrestfulapi.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.data.repository.findByIdOrNull
import arlite.kotlinrestfulapi.service.ProductService
import arlite.kotlinrestfulapi.repository.ProductRepo
import arlite.kotlinrestfulapi.entity.Product
import arlite.kotlinrestfulapi.error.NotFoundException
import arlite.kotlinrestfulapi.model.*
import arlite.kotlinrestfulapi.validation.ValidationUtil
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
  val productRepo: ProductRepo,
  val validUtil: ValidationUtil
  ) : ProductService{

  override fun create(request: CreateProductRequest): ProductResponse {

    validUtil.validate(request)

    val product = Product(
      id = request.id!!,
      name = request.name!!,
      price= request.price!!,
      quantity = request.quantity!!,
      createdAt = Date(),
      updatedAt = Date()
    )
    
    productRepo.save(product)

    return ProductResponse(
      id = product.id,
      name = product.name,
      price= product.price,
      quantity = product.quantity,
      createdAt = product.createdAt,
      updatedAt = product.updatedAt
    )
  }

  override fun get(id: String):ProductResponse {
    val product = findProductByIdOrThrowNotFound(id)
    return convertProductToProductResponse(product)
  }
  
  override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
      val page = productRepo.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
      val products: List<Product> = page.get().collect(Collectors.toList())
      return products.map { convertProductToProductResponse(it) }
  }

  private fun findProductByIdOrThrowNotFound(id: String):Product {
    val product = productRepo.findByIdOrNull(id)
    if(product == null) {
      throw NotFoundException()
    } else {
      return product;
    }
  }

  private fun convertProductToProductResponse(product: Product): ProductResponse {
    return ProductResponse(
      id= product.id,
      name= product.name,
      price= product.price,
      quantity= product.quantity,
      createdAt= product.createdAt,
      updatedAt= product.updatedAt
    )
  }
}