package com.example.reddit_popular_list.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.reddit_popular_list.model.AppState
import com.example.reddit_popular_list.model.api.ApiService
import com.example.reddit_popular_list.model.provider.IRedditHotProvider
import com.example.reddit_popular_list.model.provider.PageSourceProvider
import com.example.reddit_popular_list.model.repo.Body
import com.example.reddit_popular_list.view.base.BaseViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HotViewModel(private val redditHotProvider: IRedditHotProvider, api: ApiService): BaseViewModel<AppState>() {
    fun subscribe(): LiveData<AppState> = liveDataViewModel

//    fun flow(){
//        viewModelCoroutineScope.launch {
//            liveDataViewModel.value = AppState.Success(
//                redditHotProvider.getPageList()
//            )
//        }
//    }

    val flow: StateFlow<PagingData<Body>> = Pager(PagingConfig(20)){
        PageSourceProvider("lol",api)
    }.flow.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    fun getListOfHot(){
        viewModelCoroutineScope.launch {
            liveDataViewModel.value = AppState.Success(
                redditHotProvider.getHotList()
            )
        }
    }

    override fun errorReturned(t: Throwable) {
        println(t.message.toString())
    }
}