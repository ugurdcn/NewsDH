package com.zeygame.newsdh.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zeygame.newsdh.model.User
import io.realm.Realm

class FavoriteViewModel : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    init {
//        onAddString("Deneme Username")

        val realm = Realm.getDefaultInstance()
        val user = realm.where(User::class.java).findFirst()
        _user.postValue(user)
    }


    fun onAddString(str:String){
        val realm = Realm.getDefaultInstance()
        val denemeUser = User().apply {
            this.name=str
        }
        realm.executeTransactionAsync {
            it.insertOrUpdate(denemeUser)
            _user.postValue(denemeUser)
        }
    }
}