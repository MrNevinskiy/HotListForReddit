package com.example.reddit_popular_list.model.provider

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.reddit_popular_list.model.api.ApiService
import com.example.reddit_popular_list.model.repo.Body

class PageSourceProvider(
    private val query: String,
    private val api: ApiService
) :
    PagingSource<String, Body>() {

    override fun getRefreshKey(state: PagingState<String, Body>): String? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey ?: page.nextKey
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Body> {
        if (query.isEmpty()) {
            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
        }
        val response = api.getHotFromReddit(query, null)
        val body = checkNotNull(response.data.children.map { it.data })
        return LoadResult.Page(body, null, null)
    }
}