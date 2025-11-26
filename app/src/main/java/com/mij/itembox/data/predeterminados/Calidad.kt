package com.mij.itembox.data.predeterminados

data class Calidad(val id: Int, val descripcion: String, val mod: Double)

val CalidadesPredefinidas = listOf(
    Calidad(1, "Obra Maestra",2.0),
    Calidad(2, "Exelente",1.5),
    Calidad(3, "Buena",1.25),
    Calidad(4, "Normal",1.0),
    Calidad(5, "Mediocre",0.75),
    Calidad(6,"Mala",0.5),
    Calidad(7,"Basura",0.01)
)