package com.zeygame.newsdh.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zeygame.newsdh.model.FavoritModel
import com.zeygame.newsdh.repository.FavoritesRepository

class FavoriteViewModel   : ViewModel() {

    private val _response = MutableLiveData<List<FavoritModel>>()
    val favoritesResponse get() = _response
    val favoritesRepository=FavoritesRepository()

    init {
        _response.postValue(favoritesRepository.getAll())
    }

    fun deleteFromFavorite(favorite:FavoritModel){


    }
}