package com.one.choparpizzaclone.model

data class MovieModel<T>(
    val errorMessage: String,
    val expression: String,
    val results: T,
    val searchType: String
)