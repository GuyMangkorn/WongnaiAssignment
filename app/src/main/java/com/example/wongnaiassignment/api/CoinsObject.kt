package com.example.wongnaiassignment.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinsObject(
        @SerializedName("id")
        @Expose
        val id:Int,
        @SerializedName("description")
        @Expose
        val description:String,
        @SerializedName("name")
        @Expose
        val name:String,
        @SerializedName("iconUrl")
        @Expose
        val iconUrl:String,
) {
}