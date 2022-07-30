package com.estarta.stationery.base

abstract class BaseResponseModel{

    abstract fun getSuccess():Any?
    abstract fun getError():String?
}


