package com.estarta.stationery.koin

import com.estarta.stationery.data.repo.MatchRepository
import com.estarta.stationery.moduls.stationery.stationeryList.StationeryListRepo

import org.koin.dsl.module


val repo = module {
    single { MatchRepository(get(), get()) }
    single { StationeryListRepo(get(),get()) }
}