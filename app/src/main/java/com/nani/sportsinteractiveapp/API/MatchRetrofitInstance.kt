package com.nani.sportsinteractiveapp.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MatchRetrofitInstance {
    val BASE_URL ="https://demo.sportz.io/"

    //https://demo.sportz.io/sapk01222019186652.json

fun getmatchDetails():Retrofit{
val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit
}
}