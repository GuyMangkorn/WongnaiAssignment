package com.example.wongnaiassignment.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * API declaration retrofit http GET Method
 */
const val URL = "https://api.coinranking.com/v1/public/"
interface CryptoAPI{
    @GET("coins")
    fun getData(): Call<CryptoObject>
    companion object{
        operator fun invoke():CryptoAPI{
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CryptoAPI::class.java)
        }
    }
}