package com.chinh.news.data.api

import com.chinh.news.data.model.NewsEntity
import com.chinh.news.data.model.NewsResponse
import io.reactivex.Completable
import retrofit2.http.GET

interface ApiService{
    @GET("everything?q=tesla&from=2022-02-28&sortBy=publishedAt&apiKey=ee19aa2e5ce849f191263047734a6f1e")
    fun getNews(
    ): List<NewsEntity>
}