package com.zeygame.newsdh.repository

import com.zeygame.newsdh.model.ResultModel
import com.zeygame.newsdh.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getNews (pageIndex:Int,pageSize:Int) : Response<ResultModel>? {

        try {
            return apiService.getNews(pageIndex,pageSize)
        }catch (e:Exception){
            e.printStackTrace()
            return null
        }
    }
}