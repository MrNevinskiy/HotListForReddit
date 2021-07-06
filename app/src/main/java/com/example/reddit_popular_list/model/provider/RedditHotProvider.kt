package com.example.reddit_popular_list.model.provider

import com.example.reddit_popular_list.model.api.ApiService
import com.example.reddit_popular_list.model.repo.HotList

class RedditHotProvider(private val api: ApiService) : IRedditHotProvider {
    override suspend fun getHotList(): HotList = api.getHotFromReddit()
}