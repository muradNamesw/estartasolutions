package com.estarta.stationery.base

import androidx.lifecycle.ViewModel
import java.lang.Exception

open class BaseViewModel : ViewModel() {

    fun getIntFromStr(idValue: String): Int {
        return try {
            if (idValue.contains(".")) {
                idValue.removeRange(idValue.indexOf("."), idValue.length).toInt()
            } else {
                idValue.toInt()
            }
        } catch (e: Exception) {
            0
        }
    }
}