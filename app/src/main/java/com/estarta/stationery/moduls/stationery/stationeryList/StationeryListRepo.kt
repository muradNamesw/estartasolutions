package com.estarta.stationery.moduls.stationery.stationeryList

import androidx.lifecycle.LiveData
import com.estarta.stationery.data.source.remote.*

class StationeryListRepo(
    private val apiService: ApiService,
    private val coroutineContext: ContextProviders
)  {


    /**
    // on below line we are return
    // a function for our  return item to viewModel (StationeryListViewModel)
    //
     */

    fun getListStationery(): LiveData<Resource<StationeryListResponse>> {
        return object : NetworkBoundResource<StationeryListResponse, StationeryListResponse>(coroutineContext) {
            private var response: StationeryListResponse? = null
            override fun saveCallResult(item: StationeryListResponse) {
                response = item
            }
            override fun createCall(): LiveData<ApiResponse<StationeryListResponse>> {
                return apiService.listStationery(
                )
            }
            override fun shouldFetch(data: StationeryListResponse?) = true
            override fun loadFromDb(): LiveData<StationeryListResponse>? = null
            override fun getResult(): StationeryListResponse? = response
        }.asLiveData()

    }



}