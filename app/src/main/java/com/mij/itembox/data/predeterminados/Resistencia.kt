package com.mij.itembox.data.predeterminados

data class Resistencia(val id: Int, val descripcion: String)

val resistenciasPredefinidas = listOf(
    Resistencia(1, "Extrema"),
    Resistencia(2, "Buena"),
    Resistencia(3, "Normal"),
    Resistencia(4, "Mala"),
    Resistencia(5, "Mortal")
)