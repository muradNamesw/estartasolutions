package com.estarta.stationery.koin

import com.estarta.stationery.moduls.stationery.stationeryList.StationeryListRepo

import org.koin.dsl.module


val repo = module {
    single { StationeryListRepo(get(),get()) }
}