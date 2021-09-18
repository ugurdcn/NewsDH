package com.zeygame.newsdh.model

data class ResultModel(
    val Data: List<Data>,
    val HasError: Boolean,
    val HashErrorCode: Int,
    val Message: String,
    val Server: String,
    val UnixTime: Int
)