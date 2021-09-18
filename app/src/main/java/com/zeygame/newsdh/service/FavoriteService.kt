package com.zeygame.newsdh.service

import com.zeygame.newsdh.model.News
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.RealmResults

interface FavoriteService {
    fun save(favorite:News)

    fun getAll(): RealmResults<News>?

    fun delete(favorite: Int)

    fun isExist(Id: Int):Boolean
}