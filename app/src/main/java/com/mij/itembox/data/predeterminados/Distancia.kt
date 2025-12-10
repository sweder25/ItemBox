package com.mij.itembox.data.predeterminados

data class Distancia(val id: Int, val descripcion: String, val mod: Double)

val DistanciasPredefinidas = listOf(
    Distancia(1,"en otro continente",2.0),
    Distancia(2,"a 2 o más regiones",1.5),
    Distancia(3,"a 1 region",1.25),
    Distancia(4,"vecino",1.0)
)