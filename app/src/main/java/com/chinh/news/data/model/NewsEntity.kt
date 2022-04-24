package com.chinh.news.data.model

import androidx.room.Entity

@Entity
data class NewsEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceEntity,
    val title: String,
    val url: String,
    val urlToImage: String
)