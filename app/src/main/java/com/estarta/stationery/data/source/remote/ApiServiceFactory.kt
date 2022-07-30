package com.estarta.stationery.data.source.remote

import com.estarta.stationery.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


@Suppress("NAME_SHADOWING")
class ApiServiceFactory {

    companion object {

        private const val BASE_URL = ApiConstants.BASE_URL
        var ACCESS_TOKEN = ""

        fun getService(): ApiService {
            return synchronized(this) {

                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
                val instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .build()
                    .create(ApiService::class.java)
                instance
            }
        }

        private fun provideOkHttpClient(): OkHttpClient {


            val client = OkHttpClient.Builder()
//            client.addInterceptor(initializeHeaders("access_token_4524b40796bdb6968bcad158f729ecb636d4b094"))//Todo()
            client.addInterceptor(initializeHeaders(ACCESS_TOKEN))//Todo()

            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(interceptor)//Add Loggong Intercepter
            }
                client.connectTimeout(5*60, TimeUnit.SECONDS)
            client.readTimeout(5*60, TimeUnit.SECONDS)
            client.writeTimeout(5*60, TimeUnit.SECONDS)

            return client.build()
        }

        private fun initializeHeaders(token: String?): Interceptor {

            val headers = HashMap<String, String>()
//            token?.let {
//                headers.put("token", "${it}")
//            }
            /*if (token!!.isNotEmpty()) {
                headers.put("token", token)

            }*/
            headers.put("Content-Type", "application/json")
//            headers.put("Content Type", "application/json")
            headers.put("charset", "utf-8")
            headers.put("Accept", "application/json")

            return Interceptor { chain ->
                val original = chain.request()
                val request: Request
                val builder = original.newBuilder()
                val headers = headers
                headers.forEach {
                    builder.header(it.key, it.value)
                }
                builder.method(original.method(), original.body())
                request = builder.build()
                chain.proceed(request)
            }

        }
    }
}