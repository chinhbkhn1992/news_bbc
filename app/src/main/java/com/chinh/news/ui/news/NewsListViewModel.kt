package com.chinh.news.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chinh.news.repository.NewsRepository
import com.chinh.news.repository.model.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(val repo: NewsRepository) : ViewModel() {
    var view:NewsListView? = null
    fun startLoadData() {
        viewModelScope.launch {
            repo.getNews().collect {
               when(it){
                   is ApiResult.Loading -> {
                       view?.showLoading(it.isLoading)
                   }
                   is ApiResult.Success -> {
                       view?.handleResult(it.data)
                   }
                   is ApiResult.Error -> {
                       view?.handleError(it.exception)
                   }
               }
            }
        }
    }
}