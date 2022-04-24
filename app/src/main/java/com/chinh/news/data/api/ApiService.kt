package com.chinh.news.data.api

import com.chinh.news.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService{
    @GET("everything")
    suspend fun getNews(
        @Query("from")from:String,
        @Query("q")q:String = "tesla",
        @Query("sortBy")sortBy:String = "publishedAt",
        @Query("apiKey")apiKey:String = "ee19aa2e5ce849f191263047734a6f1e",
    ): NewsResponse
}