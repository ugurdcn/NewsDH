package com.zeygame.newsdh.service

import com.zeygame.newsdh.model.ResultModel
import com.zeygame.newsdh.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getNews(
        @Query("pageIndex") pageIndex: Int
        , @Query("pageSize") pageSize: Int // **TEST get 30 data in first page, when opening second page change that to 10
    ): Response<ResultModel>
}