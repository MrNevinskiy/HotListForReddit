package com.example.reddit_popular_list.di

import com.example.reddit_popular_list.model.provider.IRedditHotProvider
import com.example.reddit_popular_list.model.provider.RedditHotProvider
import com.example.reddit_popular_list.model.retrofit.RetrofitImplementation
import com.example.reddit_popular_list.view.HotViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitImplementation().createRetrofit() }
    single<IRedditHotProvider> { RedditHotProvider(get()) }
}

val mainMenuFragmenttModule = module {
    viewModel { HotViewModel(get()) }
}