package com.zeygame.newsdh.service

import androidx.lifecycle.LiveData
import com.zeygame.newsdh.model.Data
import io.realm.Sort


interface FavoritesService {
    fun save(data:Data)
    fun delete(data: Data)


    fun findAllSorted(sortField: String?, sort: Sort, detached: Boolean): List<Data>
    fun findAllSortedWithChanges(sortField: String?, sort: Sort): LiveData<List<Data>>

    fun getByField(field: String?, value: String?, detached: Boolean): Data?

    fun detach(data: Data) : Data
}