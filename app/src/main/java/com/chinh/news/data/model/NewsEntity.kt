package com.chinh.news.data.model

data class NewsEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceEntityRealmModel,
    val title: String,
    val url: String,
    val urlToImage: String
)