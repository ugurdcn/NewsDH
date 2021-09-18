package com.zeygame.newsdh.model

import android.os.Parcelable
import io.realm.RealmObject
import kotlinx.android.parcel.Parcelize

@Parcelize
open class FavoritModel(
    var Id: Int = 0,
    var ImageUrl: String = "",
    var ShortContent: String = "",
    var SourceUrl: String = "",
    var Title: String = "",
    var Url: String = "") : RealmObject(), Parcelable
//    @PrimaryKey
//    @RealmField("uuid")
//    var uuid: String = UUID.randomUUID().toString()

