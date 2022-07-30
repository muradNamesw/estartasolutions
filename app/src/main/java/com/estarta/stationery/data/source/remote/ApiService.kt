package com.estarta.stationery.data.source.remote

import androidx.lifecycle.LiveData
import com.estarta.stationery.moduls.stationery.stationeryList.StationeryListResponse


import retrofit2.http.*


interface ApiService {


    /**
    // on below line we are return
    // a function for our  return item to repo(StationeryListRepo)
    //
     */
        @GET("/default/dynamodb-writer")
    fun listStationery(
    ): LiveData<ApiResponse<StationeryListResponse>>


}