package com.chinh.news.data.model

data class NewsResponse(val status:String, val totalResults:Int,val articles:List<NewsEntity>)
