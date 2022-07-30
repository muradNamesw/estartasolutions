package com.estarta.stationery.koin


import com.estarta.stationery.moduls.stationery.stationeryList.StationeryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//define list view model
val viewModule = module {
    viewModel { StationeryListViewModel(get()) }

}