package com.chinh.news.repository

import com.chinh.news.repository.model.ApiResult
import com.chinh.news.repository.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
     fun getNews(): Flow<ApiResult<List<NewsModel>>>
}