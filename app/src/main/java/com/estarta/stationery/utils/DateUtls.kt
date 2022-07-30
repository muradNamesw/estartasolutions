package com.estarta.stationery.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        fun formatDate(dateText: Date): String {
            val format = SimpleDateFormat("yyyy-MM-dd")
            return format.format(dateText.time)
        }

        fun formatDateMMDDYYYY(dateText: Date): String {
            val format = SimpleDateFormat("MM-dd-yyyy")
            return format.format(dateText.time)
        }
        fun formatDateMMDDYYYYSplash(dateText: Date): String {
            val format = SimpleDateFormat("MM/dd/yyyy")
            return format.format(dateText.time)
        }
    }
}