package com.example.reddit_popular_list.model.repo

import com.google.gson.annotations.SerializedName

data class HotList(
    @SerializedName("data")
    val `data`: Data,
)