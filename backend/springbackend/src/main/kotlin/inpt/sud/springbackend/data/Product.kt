package inpt.sud.springbackend.data

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import java.io.Serializable
import javax.persistence.*


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Product : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null
    var name: String? = null
    var description: String? = null
    var currentPrice: Double = 0.0

    var promotion:Boolean = false
    var selected:Boolean = false
    var available:Boolean = false
    var photoName: String? = null
        get() = field
        set(value) {
            field = value
        }
    @ManyToOne
    public var category: Category? = null

    constructor(name: String?,  currentPrice: Double,available: Boolean, promotion: Boolean, selected: Boolean,category: Category?, photoName: String?) {
        this.name = name
        this.currentPrice = currentPrice
        this.available = available
        this.promotion = promotion
        this.selected = selected
        this.category = category
        this.photoName = photoName

    }

    @JvmName("getPhotoName1")
    fun getPhotoName(): String? {
        return photoName
    }

    @JvmName("setPhotoName1")
    fun setPhotoName(phtoName: String?) {
        photoName = phtoName
    }

}
