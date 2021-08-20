package com.reakabc.fabcoders.Networking

import com.reakabc.fabcoders.Modals.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search.php")
    fun getDrinks(@Query("f") text:String): Call<Response>

}