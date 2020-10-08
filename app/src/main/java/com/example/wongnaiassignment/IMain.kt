package com.example.wongnaiassignment

import com.example.wongnaiassignment.api.CoinsObject

interface IMain {
    interface View{
        fun resultData(arr:ArrayList<CoinsObject>)
    }
    interface Presenter{
        fun loadData()
    }
}