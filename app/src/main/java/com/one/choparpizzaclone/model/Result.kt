package com.one.choparpizzaclone.model

import java.lang.reflect.Member

data class Result(
    val title: String,
    val members: List<SubMember>
){
    data class SubMember(
        val image: Int,
        val title: String,
        val description: String,
    )
}