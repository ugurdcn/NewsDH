package com.zeygame.newsdh.repository

import com.zeygame.newsdh.model.Data
import com.zeygame.newsdh.service.FavoritesService
import io.realm.Sort
import javax.inject.Inject

class FavoritesRepository @Inject constructor(private val favoritesService: FavoritesService) {
    fun getAll()=favoritesService.findAllSorted("Id",Sort.ASCENDING,true)
    fun save(data: Data)=favoritesService.save(data)
    fun delete(data:Data) = favoritesService.delete(data)
}