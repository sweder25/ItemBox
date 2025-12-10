
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.network.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repo = UserRepository()

    private val _mensaje = MutableStateFlow("")
    val mensaje: StateFlow<String> = _mensaje

    private val _isLogged = MutableStateFlow(false)
    val isLogged: StateFlow<Boolean> = _isLogged

    fun login(email: String, pass: String) {
        viewModelScope.launch {
            val user = repo.login(email, pass)
            if (user != null) {
                _mensaje.value = "Bienvenido ${user.nombre}"
                _isLogged.value = true
            } else {
                _mensaje.value = "Credenciales incorrectas"
                _isLogged.value = false
            }
        }
    }

    fun register(nombre: String, email: String, pass: String) {
        viewModelScope.launch {
            val user = repo.register(nombre, email, pass)
            if (user != null) {
                _mensaje.value = "Usuario creado correctamente"
            } else {
                _mensaje.value = "Error al registrar"
            }
            }
    }

    fun logout() {
        _isLogged.value = false
    }
}
