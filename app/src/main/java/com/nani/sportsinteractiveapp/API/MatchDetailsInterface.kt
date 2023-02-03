package com.nani.sportsinteractiveapp.API

import com.nani.sportsinteractiveapp.Model.MatchDetails
import com.nani.sportsinteractiveapp.Model.X4
import retrofit2.Call
import retrofit2.http.GET

interface MatchDetailsInterface {
    @GET("nzin01312019187360.json")
    fun getDetailsInterface():Call<MatchDetails>

    @GET("nzin01312019187360.json")
    fun getPLayers():Call<X4>

}