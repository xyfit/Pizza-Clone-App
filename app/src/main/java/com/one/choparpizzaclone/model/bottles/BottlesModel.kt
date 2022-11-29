package com.one.choparpizzaclone.model.bottles

data class BottlesModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)