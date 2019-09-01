package com.mburcak.networking

import com.mburcak.di.Constants

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Service {

    internal lateinit var serviceApi: ServiceApi

    fun getServiceApi(): ServiceApi {
        serviceApi = instance!!.create(ServiceApi::class.java)
        return serviceApi
    }

    companion object {
        private var retrofit: Retrofit? = null


        private val instance: Retrofit?
            get() {

                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(Constants.URL_JSON)
                        .client(okHttpClientFactory)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
                }
                return retrofit
            }

        private val okHttpClientFactory: OkHttpClient
            get() {
                val builder = OkHttpClient().newBuilder()
                return builder.build()
            }
    }
}
