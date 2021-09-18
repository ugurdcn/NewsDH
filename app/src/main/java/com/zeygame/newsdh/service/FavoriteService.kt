package com.zeygame.newsdh.service

import com.zeygame.newsdh.model.FavoritModel
import io.realm.RealmResults

interface FavoriteService {
    fun save(favorite:FavoritModel)

    fun getAll(): RealmResults<FavoritModel>?

//    fun save(favorite: FavoritModel)=realm.executeTransactionAsync{it.insertOrUpdate(favorite)}
//    fun delete(Id: String) = run {
//        realm.executeTransaction {
//            val favModel: RealmQuery<FavoritModel>? =realm
//                .where(FavoritModel::class.java).equalTo("Id",Id)
//            favModel?.let {
//                favModel.realm.deleteAll()
//            }
//        }
//    }
}