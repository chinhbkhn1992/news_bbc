package com.chinh.news.ui.news

import com.chinh.news.repository.model.NewsModel

interface NewsListView {
    fun showLoading(loading: Boolean)
    fun handleResult(data: List<NewsModel>?)
    fun handleError(exception: String)
}