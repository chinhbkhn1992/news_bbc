package com.chinh.news.repository

import com.chinh.news.data.api.ApiService
import com.chinh.news.data.model.NewsRealmModel
import com.chinh.news.repository.model.NewsModel
import javax.inject.Inject

class NewsRepository @Inject constructor(val api:ApiService) {
    fun getNews():List<NewsModel> {
        val news = api.getNews()
        return
    }
}