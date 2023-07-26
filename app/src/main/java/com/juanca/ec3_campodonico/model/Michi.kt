package com.juanca.ec3_campodonico.model

import com.google.gson.annotations.SerializedName

data class Michi(
    val name: String,
    val character: String,
    val gameSeries: String,
    val image: String,
    val type: String,
    val tail: String
)
fun getData(): List<Michi> =

    listOf(
        Michi("", "Nike cupon", "Nike Store", "50", "Obten un 50% de descuento por dia del padre.", "24 June 2023"),
        Michi("", "Nike cupon", "Nike Store", "50", "Obten un 50% de descuento por dia del padre.", "24 June 2023"),
        Michi("", "Nike cupon", "Nike Store", "50", "Obten un 50% de descuento por dia del padre.", "24 June 2023"),
        Michi("", "Nike cupon", "Nike Store", "50", "Obten un 50% de descuento por dia del padre.", "24 June 2023"),
        Michi("", "Nike cupon", "Nike Store", "50", "Obten un 50% de descuento por dia del padre.", "24 June 2023"),
        Michi("", "Nike cupon", "Nike Store", "50", "Obten un 50% de descuento por dia del padre.", "24 June 2023"),
        Michi("", "Nike cupon", "Nike Store", "50", "Obten un 50% de descuento por dia del padre.", "24 June 2023"),
        Michi("", "Nike cupon", "Nike Store", "50", "Obten un 50% de descuento por dia del padre.", "24 June 2023"),

        )