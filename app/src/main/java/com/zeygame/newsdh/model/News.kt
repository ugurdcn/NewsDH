package com.zeygame.newsdh.model

import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
open class News(
    @PrimaryKey
    var Id: Int = 0,
    var ImageUrl: String = "",
    var ShortContent: String = "",
    var Title: String = "",
    var Url: String = "",
    var IsFavorite:Boolean=false
) : RealmObject(), Parcelable
//    @PrimaryKey
//    @RealmField("uuid")
//    var uuid: String = UUID.randomUUID().toString()

