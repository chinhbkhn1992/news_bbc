package com.chinh.news.di

import com.chinh.news.data.api.ApiService
import com.chinh.news.repository.NewsRepository
import com.chinh.news.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideNewsRepository(repository: NewsRepositoryImpl): NewsRepository {
        return repository
    }
}