package com.mij.itembox.network

data class BoletaRequest(
    val ventaId: Long
)

data class Boleta(
    val id: Long?,
    val numero: String?,
    val ventaId: Long?,
    val usuarioId: Long?,
    val fechaEmision: String?,
    val total: Double?,
    val emailCliente: String?,
    val direccionEnvio: String?,
    val metodoPago: String?,
    val estado: String?
)

data class ApiResponse<T>(
    val success: Boolean?,
    val message: String?,
    val data: T?
)
