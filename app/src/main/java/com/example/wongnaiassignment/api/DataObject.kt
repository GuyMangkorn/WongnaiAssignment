package com.example.wongnaiassignment.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataObject(
    @SerializedName("coins")
    @Expose
    val coins:ArrayList<CoinsObject>
) {

}
