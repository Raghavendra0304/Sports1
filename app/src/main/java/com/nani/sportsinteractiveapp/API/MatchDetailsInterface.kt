package com.nani.sportsinteractiveapp.API

import com.nani.sportsinteractiveapp.Model.MatchDetails
import com.nani.sportsinteractiveapp.Model.X4
import com.nani.sportsinteractiveapp.Model2.SecondMatchModelClass
import retrofit2.Call
import retrofit2.http.GET

interface MatchDetailsInterface {
    @GET("nzin01312019187360.json")
    fun getDetailsInterface():Call<MatchDetails>

    @GET("sapk01222019186652.json")
    fun getMatch2DetailsInterface():Call<SecondMatchModelClass>

}