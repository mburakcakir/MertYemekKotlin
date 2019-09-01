package com.mburcak.networking

import android.database.Observable
import com.mburcak.di.Constants
import com.mburcak.model.UserModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ServiceApiClient {


    @GET("posts")
    fun getUsers(): io.reactivex.Observable<List<UserModel>>


    @GET("posts/{id}")
    fun getUser(@Path("id") id: Int): io.reactivex.Observable<UserModel>

    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("posts")
    fun addUser(@Body article: UserModel): io.reactivex.Observable<UserModel>

    companion object {

        fun create(): ServiceApiClient {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.URL_JSON)
                .build()

            return retrofit.create(ServiceApiClient::class.java)

        }
    }
}