package com.mij.itembox.network

import com.mij.itembox.model.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Body

interface UserApi {

    @GET("login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<Usuario>

    @POST("register")
    suspend fun register(
        @Body usuario: Usuario
    ): Response<Usuario>
}
