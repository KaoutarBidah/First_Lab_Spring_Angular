package inpt.sud.springbackend.controller

import inpt.sud.springbackend.dao.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths


@RestController
class MyRestController {
    @Autowired
    private var productRepository: ProductRepository? = null
    fun MyRestController(p: ProductRepository) {
        productRepository = p
    }

    @GetMapping(path = ["/photoProduct/{id}"], produces = [MediaType.IMAGE_PNG_VALUE])
    @Throws(
            Exception::class
    )
    fun getPhoto(@PathVariable("id") id: Long?): ByteArray? {
        val p = productRepository!!.findById(id!!).get()
        println("####" + System.getProperty("user.home"))
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/ecom1/products/" + p.getPhotoName()))
    }

    @PostMapping(path = ["/uploadPhoto/{id}"])
    @Throws(Exception::class)
    fun uploadPhoto(file: MultipartFile, @PathVariable id: Long?) {
        val p = productRepository!!.findById(id!!).get()
        p.setPhotoName(file.originalFilename)

        Files.write(Paths.get(System.getProperty("user.home") + "/ecom1/products/" + p.getPhotoName()), file.bytes)
        productRepository!!.save(p)
    }

}
