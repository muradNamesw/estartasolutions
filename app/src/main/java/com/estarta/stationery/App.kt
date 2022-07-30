package com.estarta.stationery

import androidx.multidex.MultiDex
import com.estarta.stationery.koin.appModule
import com.estarta.stationery.koin.repo
import com.estarta.stationery.koin.viewModule
//import com.spm.cadence.utils.sunmi_utils.SunmiPrintHelper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin


/**
 * Created by Kaz on 10:28 2018-12-19
 */
class App : androidx.multidex.MultiDexApplication()//Application()
{

    val x = "x string"


    override fun onCreate() {
        super.onCreate()
//        Logger.init(true)
        initKoin()
        MultiDex.install(this)
//        Stetho.initializeWithDefaults(this);
//        OkHttpClient.Builder()
//            .addNetworkInterceptor(StethoInterceptor())
//            .build()
        appInstance = this

//        SunmiPrintHelper.getInstance().initSunmiPrinterService(this)
    }

    fun initKoin() {
        stopKoin()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, viewModule, repo))
        }
    }

    companion object {
        lateinit var appInstance: App

    }


}