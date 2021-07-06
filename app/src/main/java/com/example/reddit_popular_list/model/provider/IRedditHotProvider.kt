package com.example.reddit_popular_list.model.provider

import com.example.reddit_popular_list.model.repo.HotList

interface IRedditHotProvider {
    suspend fun getHotList(): HotList
}