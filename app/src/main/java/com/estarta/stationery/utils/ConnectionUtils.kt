package com.estarta.stationery.utils

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Base64
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class NetworkConnectionUtils {

    companion object {
        var pref: PreferenceStorage? = null

        fun getHeader(): String {
//            val username: String = "admin@sbm.com.sa"
//            val password:  String = "Admin@123"


            val username: String = pref!!.getUserName().toString()
            val password:  String = pref!!.getPassword().toString()
            val credentials:  String = "$username:$password"

            return "Basic " + Base64.encodeToString(
                credentials.toByteArray(Charsets.UTF_8),
                Base64.DEFAULT
            ).replace("\n", "")
        }

        fun checkInternet(context: Context): Boolean {
            var isConnected: Boolean? = null
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            if (activeNetwork == null) {

                isConnected = false
            } else {
                isConnected = activeNetwork?.isConnected!!
            }

            if (!isConnected) {
                if (pref == null)
                    pref = PreferenceStorage(context)
                var enableOffline = pref?.isEnableOffline()
                isConnected = !enableOffline!!
            }
            return isConnected!!
        }
    }
}

object ProgressDialogUtil {

    fun setProgressDialog(context: Context, message: String): AlertDialog {
        val padding = 50
        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.HORIZONTAL
        linearLayout.setPadding(padding, padding, padding, padding)
        linearLayout.gravity = Gravity.START
        var params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER
        linearLayout.layoutParams = params

        val progressBar = ProgressBar(context)
        progressBar.isIndeterminate = true
        progressBar.setPadding(0, 0, padding, 0)
        progressBar.layoutParams = params

        params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER
        val tvText = TextView(context)
        tvText.text = message
        tvText.setTextColor(Color.parseColor("#008577"))
        tvText.textSize = 20.toFloat()
        tvText.layoutParams = params

        linearLayout.addView(progressBar)
        linearLayout.addView(tvText)

        val builder = AlertDialog.Builder(context)
        builder.setCancelable(false)
        builder.setView(linearLayout)

        val dialog = builder.create()
        val window = dialog.window
        if (window != null) {
            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window?.attributes)
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            dialog.window?.attributes = layoutParams
        }
        return dialog
    }
}