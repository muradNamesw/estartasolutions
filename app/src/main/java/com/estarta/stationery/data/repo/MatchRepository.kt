package com.estarta.stationery.data.repo

import com.estarta.stationery.data.source.remote.ApiService
import com.estarta.stationery.data.source.remote.ContextProviders


class MatchRepository constructor(
    private val apiService: ApiService,
    private val coroutineContext: ContextProviders
) {
    fun getCount(): Int  = 23


}