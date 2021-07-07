package com.example.reddit_popular_list.model.api

import com.example.reddit_popular_list.model.repo.HotList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{subreddit}/hot.json")
    suspend fun getHotFromReddit(
        @Path("subreddit") subreddit: String,
        @Query("after") after: String?
    ): HotList
}