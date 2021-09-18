package com.zeygame.newsdh.repository

import com.zeygame.newsdh.model.FavoritModel
import com.zeygame.newsdh.service.FavoriteService
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject


class FavoritesRepository : FavoriteService{
    val realm=Realm.getDefaultInstance()

    override fun save(favorite: FavoritModel) {
        realm.executeTransactionAsync{
            it.insertOrUpdate(favorite)
        }
    }


     override fun getAll()=realm.where(FavoritModel::class.java).findAll()

//    fun save(favorite: FavoritModel)=realmService.executeTransactionAsync{it.insertOrUpdate(favorite)}
//    fun delete(Id: String) {
//
//        realmService.executeTransaction {
//            val favModel: RealmQuery<FavoritModel>? =realmService
//                .where(FavoritModel::class.java).equalTo("Id",Id)
//            favModel?.let {
//                favModel.realm.deleteAll()
//            }
//        }
//    }
}