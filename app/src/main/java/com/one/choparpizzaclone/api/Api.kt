package com.one.choparpizzaclone.api

import com.one.choparpizzaclone.model.MovieModel
import com.one.choparpizzaclone.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("Search/{key}/{film_name}")
    fun getFilmData(@Path("key") key:String, @Path("film_name") film_name:String): Call<MovieModel<List<Result>>>
}