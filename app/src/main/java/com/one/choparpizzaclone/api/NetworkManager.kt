package com.one.choparpizzaclone.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    var retrofit: Retrofit? = null
    var api: Api? = null
    fun apiClient(): Api {
        if (api == null) {
            retrofit = Retrofit.Builder().baseUrl("https://imdb-api.com/API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            api = retrofit!!.create(Api::class.java)
        }
        return api!!

    }
}