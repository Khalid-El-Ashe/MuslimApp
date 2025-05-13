package com.dev.imuslim.network

import com.dev.imuslim.models.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val baseUrl = Constants.BASE_URL

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: AppApiService by lazy {
        retrofit.create(AppApiService::class.java)
    }

//    fun getInstance(): Retrofit {
//        return Retrofit.Builder().baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create()).build()
//    }
}