import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mij.itembox.data.model.Producto

@Entity(
    tableName = "minerales",
    foreignKeys = [ForeignKey(
        entity = Producto::class,
        parentColumns = ["id_producto"],
        childColumns = ["id_producto"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Mineral(
    @PrimaryKey val id_producto: Long,
    val rareza: Int,
    val magia: Int,
    val valor_base: Double,
    val descripcion_objeto: String,
    val principal_provehedor: Int,
    val bioma_ideal: Int,
    val peso: Double
)