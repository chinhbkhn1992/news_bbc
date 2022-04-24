package com.chinh.news.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chinh.news.repository.model.NewsModel

@Database(entities = [NewsModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract val newsDao: NewsDAO
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "news_database")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}