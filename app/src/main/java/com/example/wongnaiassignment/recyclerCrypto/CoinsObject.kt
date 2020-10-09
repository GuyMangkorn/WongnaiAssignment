package com.example.wongnaiassignment.recyclerCrypto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Object ArrayList of coins icon,description,name
 */
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