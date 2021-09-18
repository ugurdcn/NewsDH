package com.zeygame.newsdh.repository

import com.zeygame.newsdh.service.ApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getNews(pageIndex:Int,pageSize:Int)=apiService.getNews(pageIndex,pageSize)
}