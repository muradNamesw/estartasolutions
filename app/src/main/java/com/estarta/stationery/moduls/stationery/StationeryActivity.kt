package com.estarta.stationery.moduls.stationery

import android.os.Bundle
import com.estarta.stationery.R
import com.estarta.stationery.base.BaseActivity
import com.estarta.stationery.databinding.ActivityStationeryBinding
import com.estarta.stationery.moduls.stationery.stationeryList.StationeryListFragment



/**
 *
 *
In BaseActivity there are all common methods of each application.
In order to standardize the code there are:
getLayoutRes:Connecting design with class
updateUI:Complete the code as needed
 * @param
 * @return fragment
 *
 */

/**
 *
 *
please view package koin

(
https://insert-koin.io/docs/reference/koin-android/viewmodel/
https://insert-koin.io/
 )
 *
 */


class StationeryActivity : BaseActivity<ActivityStationeryBinding>() {

    override fun getLayoutRes(): Int = R.layout.activity_stationery


    override fun updateUI(savedInstanceState: Bundle?) {
        replaceFragment(
            StationeryListFragment(), R.id.fragment_container_stationery, true
        )
    }




}