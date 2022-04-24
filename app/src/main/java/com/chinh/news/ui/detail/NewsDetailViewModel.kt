package com.chinh.news.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chinh.news.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(repo: NewsRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    var view: NewsDetailView? = null

}