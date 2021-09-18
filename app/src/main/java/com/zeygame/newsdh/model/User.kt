package com.zeygame.newsdh.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import java.util.*


open class User : RealmObject() {
    @PrimaryKey
    @RealmField("id")
    var uuid: String = UUID.randomUUID().toString()

    var name :String =""

}