package com.example.wongnaiassignment

import com.example.wongnaiassignment.recyclerCrypto.CoinsObject

/**
 * Interface for load data to Crypto Recyclerview
 */
interface IMain {
    interface View{
        fun resultData(arr:ArrayList<CoinsObject>)
    }
    interface Presenter{
        fun loadData()
    }
}