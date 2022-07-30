package com.estarta.stationery.interfaces

interface ErrorMessageHandler {

    fun getMessage() : String?

    fun onRetry() : Unit
}