package com.chinh.news.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chinh.news.repository.model.NewsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDAO {
    @Query("SELECT * FROM newsmodel ORDER BY publishedAt ASC")
    suspend fun getAll(): List<NewsModel>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: NewsModel)
}