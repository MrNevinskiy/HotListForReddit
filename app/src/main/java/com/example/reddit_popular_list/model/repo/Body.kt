package com.example.reddit_popular_list.model.repo

import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("total_awards_received")
    val totalAwardsReceived: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("num_comments")
    val numComments: Int,
)