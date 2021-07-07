package com.example.reddit_popular_list.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.reddit_popular_list.model.AppState
import com.example.reddit_popular_list.model.api.ApiService
import com.example.reddit_popular_list.model.provider.PageSourceProvider
import com.example.reddit_popular_list.model.repo.Body
import com.example.reddit_popular_list.view.base.BaseViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HotViewModel(api: ApiService): BaseViewModel<AppState>() {

    fun subscribe(): LiveData<AppState> = liveDataViewModel

    val flow: StateFlow<PagingData<Body>> = Pager(PagingConfig(10)){
        PageSourceProvider("lol",api)
    }.flow.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    override fun errorReturned(t: Throwable) {
        println(t.message.toString())
    }
}