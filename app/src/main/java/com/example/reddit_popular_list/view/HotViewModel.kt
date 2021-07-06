package com.example.reddit_popular_list.view

import androidx.lifecycle.LiveData
import com.example.reddit_popular_list.model.AppState
import com.example.reddit_popular_list.model.provider.IRedditHotProvider
import com.example.reddit_popular_list.view.base.BaseViewModel
import kotlinx.coroutines.launch

class HotViewModel(private val redditHotProvider: IRedditHotProvider): BaseViewModel<AppState>() {

    fun subscribe(): LiveData<AppState> = liveDataViewModel

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