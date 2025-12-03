package com.mij.itembox.network

import retrofit2.http.Body
import retrofit2.http.POST

interface BoletaApi {
    @POST("api/boletas")
    suspend fun generarBoleta(@Body request: BoletaRequest): ApiResponse<Boleta>
}
