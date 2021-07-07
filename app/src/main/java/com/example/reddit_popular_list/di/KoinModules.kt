package com.example.reddit_popular_list.di

import com.example.reddit_popular_list.model.retrofit.RetrofitImplementation
import com.example.reddit_popular_list.view.HotViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitImplementation().createRetrofit() }
}

val mainMenuFragmentModule = module {
    viewModel { HotViewModel(get()) }
}