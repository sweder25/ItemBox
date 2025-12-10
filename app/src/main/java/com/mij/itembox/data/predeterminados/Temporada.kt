package com.mij.itembox.data.predeterminados

data class Temporada(val id: Int, val descripcion: String)

val TemporadasPredefinidas = listOf(
    Temporada(1,"Invierno"),
    Temporada(2,"Primavera"),
    Temporada(3,"Verano"),
    Temporada(4,"Otoño")
)