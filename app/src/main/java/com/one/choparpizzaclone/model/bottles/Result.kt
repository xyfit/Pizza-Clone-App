package com.one.choparpizzaclone.model.bottles

data class Result(
    val category: Category,
    val count: String,
    val `field`: Field,
    val height: Int,
    val id: String,
    val images: List<String>,
    val length: Int,
    val min_order: Int,
    val name: String,
    val neck_diameter: Int,
    val price: Int,
    val volume: Int,
    val weight: Double,
    val width: Int
)