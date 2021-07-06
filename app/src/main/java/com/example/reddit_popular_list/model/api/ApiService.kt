package com.example.reddit_popular_list.model.api

import com.example.reddit_popular_list.model.repo.HotList
import retrofit2.http.GET

interface ApiService {
    @GET("hot.json")
    suspend fun getHotFromReddit(): HotList
}