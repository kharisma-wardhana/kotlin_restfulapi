package arlite.kotlinrestfulapi.entity
import java.util.*
import javac.persistence.Entity
import javac.persistence.Table
import javac.persistence.Id
import javac.persistence.Column

@Entity
@Table(name = "products")
data class Product(
  @Id
  val id: String,

  @Column(name = "name")
  val name: String,
  
  @Column(name = "price")
  val price: Long,
  
  @Column(name = "quantity")
  val quantity: Int,
  
  @Column(name = "createdAt")
  val createdAt: Date,
  
  @Column(name = "updatedAt")
  val updatedAt: Date? 
)