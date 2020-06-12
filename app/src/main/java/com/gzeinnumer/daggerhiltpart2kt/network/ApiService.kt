package com.gzeinnumer.daggerhiltpart2kt.network

import com.gzeinnumer.daggerhiltpart2kt.network.model.ResponseCuaca
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


//todo 5
interface ApiService {
    @GET("data/2.5/forecast")
    fun getCuaca(
        @Query("id") id: String,
        @Query("appid") appid: String,
        @Query("units") units: String
    ): Call<ResponseCuaca>
}