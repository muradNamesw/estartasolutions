package com.estarta.stationery.moduls.stationery.stationeryList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.estarta.stationery.base.BaseViewModel
import com.estarta.stationery.data.source.remote.Resource

class StationeryListViewModel  (
    open val repo: StationeryListRepo
) : BaseViewModel(){

    /**
    // on below line we are create
    // a variable for our visible xml list or empty
    //
     */
    var visibleStationeryList: Boolean = false

    /**
    // on below line we are create
    // a variable for our add item
    //
     */
    var stationeryList: ArrayList<StationeryListModel?>? = null
    private var stationeryAll = MutableLiveData<StationeryListResponse>()

    /**
    // on below line we are return
    // a variable for our return api and add item (stationeryList)
    //
     */
    var resultStationery = Transformations.switchMap(stationeryAll) {
        repo.getListStationery()
    }
    fun getStationeryListViewModel(){
        resultStationery = repo.getListStationery()
    }



    /**
    // on below line we are return
    // a function for our validate return result and visible xml list or empty
    //
     */

    fun validateNullOrEmpty(it: Resource<StationeryListResponse>): Boolean {

        if (it!=null){
            if (it.data!!.results!!.size>0){
                visibleStationeryList = true
                return true
            }
        }
        visibleStationeryList = false
        return false
    }


}