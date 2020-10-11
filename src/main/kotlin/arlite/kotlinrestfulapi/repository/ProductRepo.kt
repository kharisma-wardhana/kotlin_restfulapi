package arlite.kotlinrestfulapi.repository
import org.springframework.data.jpa.repository.JpaRepository
import arlite.kotlinrestfulapi.entity.Product

interface ProductRepo : JpaRepository<Product, String> {

}