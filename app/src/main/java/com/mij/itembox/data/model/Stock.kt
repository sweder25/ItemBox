import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mij.itembox.data.model.Inventario
import com.mij.itembox.data.model.Producto

@Entity(
    tableName = "stock",
    foreignKeys = [
        ForeignKey(
            entity = Inventario::class,
            parentColumns = ["id_inventario"],
            childColumns = ["inventario_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = Producto::class, parentColumns = ["id_producto"], childColumns = ["producto_id"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("inventario_id"), Index("producto_id")]
)
data class Stock(
    @PrimaryKey(autoGenerate = true) val id_stock: Long = 0,
    val inventario_id: Long,
    val producto_id: Long,
    val cantidad: Int
)