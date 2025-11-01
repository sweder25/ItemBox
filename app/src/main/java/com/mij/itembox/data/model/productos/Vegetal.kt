import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mij.itembox.data.model.Producto

@Entity(
    tableName = "vegetales",
    foreignKeys = [ForeignKey(
        entity = Producto::class,
        parentColumns = ["id_producto"],
        childColumns = ["id_producto"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Vegetal(
    @PrimaryKey val id_producto: Long,
    val rareza: Int,
    val temporada: Int,
    val resistencia_frio: Int,
    val resistencia_calor: Int,
    val resistencia_humedad: Int,
    val resistencia_sequia: Int,
    val resistencia_luz: Int,
    val descripcion: String,
    val valor_base: Double,
    val propiedades: String,
    val bioma_ideal: Int,
    val magia: Int,
    val principal_provehedor: Int,
    val peso: Double
)