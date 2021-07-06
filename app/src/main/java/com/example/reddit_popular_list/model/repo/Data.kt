package com.example.reddit_popular_list.model.repo

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("children")
    val children: List<Children>,
    @SerializedName("dist")
    val dist: Int,
)