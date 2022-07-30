package com.estarta.stationery.utils

import android.content.Context
import java.util.*

/**
 * Storage for app and user preferences.
 */
class PreferenceStorage(val context: Context) {

    private val USERNAME = "username2"
    private val ALLOWEDIT = "ALLOWEDIT"
    private val USERNAME_Menu = "USERNAME_Menu"
    private val USERID = "USERID"
    private val LATEST_ITEM_ID = "latest_item_id"
    private val JOB_SECHDULED = "job_sechduled"
    private val EXPIRE_DATE: String = "expiresDate"
    private val LATEST_TRANS_ID = "latest_trans_id"
    private val PASSWORD: String = "password"
    private val ISLOGGEDIN: String = "loggedin2"
    private val ACCESS_TOKEN: String = "access_token"
    private val INVOICE_NUMBER: String = "invoice_number"
    private val CAN_UPDATE_QUANTITY: String = "can_update_quantity"
    private val PUSH_STARTED: String = "push_started"
    private val ENABLE_OFFLINE: String = "enable_offline"


    private val PREF: String = "pref"


    private val UPDATE_TRANSACTION = "UPDATE_TRANSACTION"


    fun saveUpdateTransaction(stat: Boolean) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean(UPDATE_TRANSACTION, stat)
        editor.commit()
    }

    fun checkUpdateTransaction(): Boolean? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getBoolean(UPDATE_TRANSACTION, false)
    }

    fun isLoggedin(): Boolean {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getBoolean(ISLOGGEDIN, false)
    }

    fun setLoggedin(isLoggedin: Boolean) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean(ISLOGGEDIN, isLoggedin)
        if (!isLoggedin)
            editor.remove(USERNAME)
        editor.commit()
    }


    fun setUser(username: String) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(USERNAME, username)
        editor.commit()
    }

    fun setUserName(username: String) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(USERNAME_Menu, username)
        editor.commit()
    }

    fun getUserName(): String? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getString(USERNAME_Menu, "")
    }

    fun setPassword(password: String) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(PASSWORD, password)
        editor.commit()
    }
    fun getPassword(): String? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getString(PASSWORD, "")
    }

    fun setAllowEdit(username: Boolean) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean(ALLOWEDIT, username)
        editor.commit()
    }

    fun isAllowEdit(): Boolean {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getBoolean(ALLOWEDIT, false)
    }


    fun setUserId(userID: Int) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putInt(USERID, userID)
        editor.commit()
    }


    fun getUser(): String? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getString(USERNAME, "")
    }



    fun getUserId(): Int? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getInt(USERID, -1)
    }

    fun getInvoiceNumber(): String? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        var number = preference.getInt(INVOICE_NUMBER, 1)
        if (number > 9999)
            number = 1
        return java.lang.String.format(Locale.US, "%04d", number)
    }

    fun getIntegerInvoiceNumber(): Int {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getInt(INVOICE_NUMBER, 1)
    }

    fun setInvoiceNumber() {
        var number = getIntegerInvoiceNumber()
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putInt(INVOICE_NUMBER, number + 1)
        editor.commit()
    }

    fun getLatestTransID(): Int? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getInt(LATEST_TRANS_ID, -1)
    }

    fun setLatestTransID(id: Int) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putInt(LATEST_TRANS_ID, id)
        editor.commit()
    }

    fun getLatestItemID(): Int? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getInt(LATEST_ITEM_ID, -1)
    }

    fun saveJobSechduled(stat: Boolean) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean(JOB_SECHDULED, stat)
        editor.commit()
    }

    fun checkJobSechduled(): Boolean? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getBoolean(JOB_SECHDULED, false)
    }

    fun setLatestItemID(id: Int) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putInt(LATEST_ITEM_ID, id)
        editor.commit()
    }





    fun setExpiryDate(expiresDate: String) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(EXPIRE_DATE, expiresDate)
        editor.commit()
    }


    fun getExpiryDate(): String? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getString(EXPIRE_DATE, "")
    }



    fun setAccessToken(accessToken: String?) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString(ACCESS_TOKEN, accessToken)
        editor.commit()

    }

    fun getAccessToken(): String? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getString(ACCESS_TOKEN, "")
    }

    fun setEnableOffline(enableOffline: Boolean?) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean(ENABLE_OFFLINE, enableOffline!!)
        editor.commit()

    }


    fun isEnableOffline(): Boolean? {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getBoolean(ENABLE_OFFLINE, false)
    }

    fun getCanUpdateQuantity(): Boolean {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getBoolean(CAN_UPDATE_QUANTITY, true)
    }

    fun disableUpdateQuantity() {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean(CAN_UPDATE_QUANTITY, false)
        editor.commit()
    }

    fun pushStarted(started: Boolean) {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean(PUSH_STARTED, started)
        editor.commit()
    }

    fun isPushStarted(): Boolean {
        val preference = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return preference.getBoolean(PUSH_STARTED, false)
    }

}
