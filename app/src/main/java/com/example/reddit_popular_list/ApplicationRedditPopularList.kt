package com.example.reddit_popular_list

import android.app.Application
import com.example.reddit_popular_list.di.appModule
import com.example.reddit_popular_list.di.mainMenuFragmentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationRedditPopularList: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(applicationContext)
            modules(listOf(
                appModule,
                mainMenuFragmentModule
            ))
        }
    }
}