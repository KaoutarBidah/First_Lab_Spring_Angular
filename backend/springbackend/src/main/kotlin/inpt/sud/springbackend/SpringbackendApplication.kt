package inpt.sud.springbackend

import inpt.sud.springbackend.dao.CategoryRepository
import inpt.sud.springbackend.dao.ProductRepository
import inpt.sud.springbackend.data.Category
import inpt.sud.springbackend.data.Product
import net.bytebuddy.utility.RandomString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import kotlin.random.Random

@SpringBootApplication
class SpringbackendApplication : CommandLineRunner {

   @Autowired
    var repositoryRestConfiguration: RepositoryRestConfiguration? = null

    @Autowired
    var productRepository: ProductRepository? = null

    @Autowired
    var categoryRepository: CategoryRepository? = null



    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringbackendApplication>(*args)
        }
    }
    override fun run(vararg args: String?) {
        repositoryRestConfiguration?.exposeIdsFor(Product::class.java, Category::class.java)
        /*categoryRepository?.save(Category(null,"computers",null,null))
        categoryRepository?.save(Category(null,"Printers",null,null))
        categoryRepository?.save(Category(null,"Smartphones",null,null))

        categoryRepository?.findAll()?.forEach { category : Category? ->

            for(i in 1..10){
                 val p = Product(RandomString.make(10), 100 + Random.nextInt(10000).toDouble(), Random.nextBoolean(), Random.nextBoolean(),Random.nextBoolean(), category,"unknown.png")
                 productRepository?.save(p)

            }
        }*/

    }
}

