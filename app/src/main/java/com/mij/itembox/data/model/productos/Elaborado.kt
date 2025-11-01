import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mij.itembox.data.model.Producto

@Entity(
    tableName = "elaborados",
    foreignKeys = [ForeignKey(
        entity = Producto::class,
        parentColumns = ["id_producto"],
        childColumns = ["id_producto"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Elaborado(
    @PrimaryKey val id_producto: Long,
    val valor_base: Double,
    val rareza: Int,
    val magia: Int,
    val descripcion_objeto: String,
    val descripcion_propiedades: String,
    val principal_provehedor: Int,
    val peso: Double
)