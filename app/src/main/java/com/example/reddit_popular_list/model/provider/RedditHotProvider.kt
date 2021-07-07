package com.example.reddit_popular_list.model.provider

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.reddit_popular_list.model.api.ApiService
import com.example.reddit_popular_list.model.repo.Body
import com.example.reddit_popular_list.model.repo.HotList

class RedditHotProvider(private val api: ApiService) : IRedditHotProvider {
    override suspend fun getHotList(): HotList = api.getHotFromReddit("lol", null)
    override suspend fun getPageList(): Pager<String, Body>
    = Pager(PagingConfig(20)){ PageSourceProvider("lol", api)}
}