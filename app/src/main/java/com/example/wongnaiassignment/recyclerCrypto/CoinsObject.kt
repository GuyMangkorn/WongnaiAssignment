package com.example.wongnaiassignment.recyclerCrypto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinsObject(
        @SerializedName("description")
        @Expose
        val description:String,
        @SerializedName("name")
        @Expose
        val name:String,
        @SerializedName("iconUrl")
        @Expose
        val iconUrl:String,
)