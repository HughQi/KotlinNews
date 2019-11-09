package com.example.kotlinnews.Service

import com.example.kotlinnews.Model.News
import retrofit2.Call
import retrofit2.http.GET

interface GetChildrenService {

    @GET("/r/kotlin/.json")
    fun getAllChildren(): Call<News>
}