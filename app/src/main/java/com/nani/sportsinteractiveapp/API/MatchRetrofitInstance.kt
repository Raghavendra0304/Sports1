package com.nani.sportsinteractiveapp.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MatchRetrofitInstance {
    val BASE_URL ="https://demo.sportz.io/"

fun getmatchDetails():Retrofit{
val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit
}
}