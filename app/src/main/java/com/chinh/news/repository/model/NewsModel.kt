package com.chinh.news.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chinh.news.data.model.NewsEntity
import java.io.Serializable

fun NewsEntity.toModel(): NewsModel {
    return NewsModel(
        this.author,
        this.content,
        this.description,
        this.publishedAt,
        this.title,
        this.url,
        this.urlToImage,
    )
}


@Entity
data class NewsModel(
    @ColumnInfo(name = "author")
    val author: String?,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String,
    @ColumnInfo(name = "title")
    val title: String,
    @PrimaryKey
    val url: String,
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String?
):Serializable