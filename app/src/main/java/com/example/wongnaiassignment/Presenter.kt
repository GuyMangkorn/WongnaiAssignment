package com.example.wongnaiassignment

import android.util.Log
import com.example.wongnaiassignment.recyclerCrypto.CoinsObject
import com.example.wongnaiassignment.api.CryptoAPI
import com.example.wongnaiassignment.api.CryptoObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Presenter class call Api Request to CryptoObjects
 */
class Presenter(private val context: IMain.View) :IMain.Presenter{
    override fun loadData() {
        CryptoAPI().getData().enqueue(object : Callback<CryptoObject> {
            override fun onResponse(call: Call<CryptoObject>, response: Response<CryptoObject>) {
                val arr:ArrayList<CoinsObject> = response.body()!!.data.coins
                context.resultData(arr)
            }
            override fun onFailure(call: Call<CryptoObject>, t: Throwable) {
                Log.d("ERROR_ON_CALL_API",t.toString())
            }

        })
    }
}