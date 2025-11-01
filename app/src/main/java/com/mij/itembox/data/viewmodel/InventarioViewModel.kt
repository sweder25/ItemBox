import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.model.Inventario
import com.mij.itembox.data.repository.InventarioRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class InventarioViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getInstance(application).inventarioDao()
    private val repository = InventarioRepository(dao)

    val allItems: Flow<List<Inventario>> = repository.allItems

    fun insert(inventario: Inventario) {
        viewModelScope.launch { repository.insert(inventario) }
    }

    fun delete(inventario: Inventario) {
        viewModelScope.launch { repository.delete(inventario) }
    }

    fun getInventario(id: Long): Flow<Inventario> = repository.getById(id)

    suspend fun getInventarioDirecto(id: Long): Inventario = repository.getByIdSuspend(id)

    fun actualizarDinero(id: Long, nuevoMonto: Double) {
        viewModelScope.launch {
            repository.actualizarDinero(id, nuevoMonto)
        }
    }
}