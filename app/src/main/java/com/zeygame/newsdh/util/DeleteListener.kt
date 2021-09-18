package com.zeygame.newsdh.util

import com.zeygame.newsdh.model.News

interface DeleteListener {
    fun onDelete(news: News)
}