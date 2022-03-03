package inpt.sud.springbackend.data

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import java.io.Serializable
import javax.persistence.*

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Category(@Id
               @GeneratedValue(strategy = GenerationType.IDENTITY)
               var id: Long?,   var name: String?,  var description: String?, @OneToMany(mappedBy = "category")
               var products: Collection<Product>?) : Serializable
