package com.example.reddit_popular_list.model.repo

import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("data")
    val `data`: Body,
)