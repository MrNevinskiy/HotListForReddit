package com.example.reddit_popular_list.model.provider

import androidx.paging.Pager
import com.example.reddit_popular_list.model.repo.Body
import com.example.reddit_popular_list.model.repo.HotList

interface IRedditHotProvider {
    suspend fun getHotList(): HotList
    suspend fun getPageList(): Pager<String, Body>
}