package inpt.sud.springbackend.dao

import inpt.sud.springbackend.data.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.web.bind.annotation.CrossOrigin


@CrossOrigin("*")
@RepositoryRestResource
interface ProductRepository : JpaRepository<Product?, Long?> {
    @RestResource(path= "/selectedProducts")
    fun findBySelectedIsTrue(): List<Product?>?

    @RestResource(path = "/productsByKeyword")
    fun findByNameContains(@Param("mc") mc: String?): List<Product?>?

    @RestResource(path = "/promoProducts")
    fun findByPromotionIsTrue(): List<Product?>?

    @RestResource(path = "/dispoProducts")
    fun findByAvailableIsTrue(): List<Product?>?

}



