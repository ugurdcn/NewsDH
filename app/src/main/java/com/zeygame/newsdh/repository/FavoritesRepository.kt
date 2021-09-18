package com.zeygame.newsdh.repository

import android.content.Context
import com.zeygame.newsdh.model.News
import com.zeygame.newsdh.service.FavoriteService
import com.zeygame.newsdh.util.Constants
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmQuery
import io.realm.kotlin.delete


class FavoritesRepository : FavoriteService{
    val realm = Realm.getDefaultInstance()

    override fun save(favorite: News) {
        realm.executeTransactionAsync{
            it.insertOrUpdate(favorite)
        }
    }

    override fun getAll()=realm.where(News::class.java).findAll()



    override fun delete(Id: Int) {
        realm.executeTransactionAsync {
            val fav = it.where(News::class.java).equalTo("Id",Id).findFirst()
            fav?.deleteFromRealm()
        }
    }

    override fun isExist(Id: Int): Boolean {
        val fav= realm.where(News::class.java).equalTo("Id",Id).findFirst()
        return fav!=null
    }
}