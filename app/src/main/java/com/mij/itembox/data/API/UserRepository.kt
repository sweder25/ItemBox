package com.mij.itembox.network

import com.mij.itembox.model.Usuario

class UserRepository {

    private val api = RetrofitClient.retrofit.create(UserApi::class.java)

    suspend fun login(email: String, password: String): Usuario? {
        val res = api.login(email, password)
        return if (res.isSuccessful) res.body() else null
    }

    suspend fun register(nombre: String, email: String, password: String): Usuario? {
        val nuevo = Usuario(0, nombre, email, password)
        val res = api.register(nuevo)
        return if (res.isSuccessful) res.body() else null
    }
}
