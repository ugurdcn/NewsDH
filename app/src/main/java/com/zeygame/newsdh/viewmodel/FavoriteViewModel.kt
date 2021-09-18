package com.zeygame.newsdh.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zeygame.newsdh.model.News
import com.zeygame.newsdh.repository.FavoritesRepository
import io.realm.RealmChangeListener

class FavoriteViewModel : ViewModel() {

    private val _response = MutableLiveData<List<News>>()
    val favoritesResponse : LiveData<List<News>> get() = _response
    val favoritesRepository=FavoritesRepository()

    init {
        favoritesRepository.getAll()?.let {
            if (it.size>0){
                _response.postValue(it)
            }
        }
        changeListener()
    }

    /*-
    *Veritabanı dinleyicisi
    * Not: Realm in özelliklerini ve kararlılığını test etmek için oluşturuldu
    * */
    open fun changeListener()=favoritesRepository.getAll().addChangeListener(RealmChangeListener {
        Log.d("MYTAG", "changeListener is running")
        if (it.size>0)_response.postValue(it)
        else _response.postValue(arrayListOf())
    })

}