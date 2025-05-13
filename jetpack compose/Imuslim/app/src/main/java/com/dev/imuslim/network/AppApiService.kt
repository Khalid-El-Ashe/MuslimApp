package com.dev.imuslim.network

import com.dev.imuslim.models.Athckar
import com.dev.imuslim.models.Stories
import retrofit2.http.GET

interface AppApiService {
    @GET("athckar.json")
    suspend fun getAthkar(): List<Athckar>

    @GET("stories.json")
    suspend fun getQuranicStories(): List<Stories>
}