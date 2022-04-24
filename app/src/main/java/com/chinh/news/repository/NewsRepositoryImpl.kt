package com.chinh.news.repository

import com.chinh.news.data.api.ApiService
import com.chinh.news.data.db.NewsDAO
import com.chinh.news.repository.model.ApiResult
import com.chinh.news.repository.model.NewsModel
import com.chinh.news.repository.model.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    val api: ApiService,
    val dao: NewsDAO
) : NewsRepository {
    override fun getNews(): Flow<ApiResult<List<NewsModel>>> {
        return flow {
            emit(ApiResult.Loading(isLoading = true))
           try{
               val cal = Calendar.getInstance()
               cal.add(Calendar.DAY_OF_MONTH, -1)
               val date = SimpleDateFormat("yyyy-MM-dd").format(cal.time)
               val data = api.getNews(date).articles.map {
                   it.toModel()
               }
               data.forEach {
                   dao.insertNews(it)
               }


           }catch (e:Exception){
               emit(ApiResult.Error(_exceptionObject = e, exception = e.message!!))
           }
            val news = dao.getAll()
            emit(ApiResult.Success(news))
            emit(ApiResult.Loading(isLoading = false))
        }
    }
}