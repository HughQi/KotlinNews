package com.example.kotlinnews.Model

import com.google.gson.annotations.SerializedName

data class News(@SerializedName("data") val data: ChildrenList)

data class ChildrenList(@SerializedName("children") val children: MutableList<ChildrenData>)

data class ChildrenData(@SerializedName("data") val data: Children)

data class Children(@SerializedName("subreddit") val subreddit: String,
                    @SerializedName("selftext") val selftext: String,
                    @SerializedName("title") val title: String,
                    @SerializedName("name") val name: String,
                    @SerializedName("thumbnail") val thumbnail: String)