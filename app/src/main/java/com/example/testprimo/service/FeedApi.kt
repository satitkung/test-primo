package com.example.testprimo.service

import com.example.testprimo.model.Feed
import retrofit2.http.GET

interface FeedApi {

    @GET("feed/@primoapp")
    suspend fun getFeed(): Feed

}


