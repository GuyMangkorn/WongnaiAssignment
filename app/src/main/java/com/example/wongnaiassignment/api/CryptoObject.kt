package com.example.wongnaiassignment.api

import com.google.gson.annotations.SerializedName

/**
 * Object data in json
 */
class CryptoObject (
    @SerializedName("data")
    val data:DataObject,
    )