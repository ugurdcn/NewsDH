package com.zeygame.newsdh

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.log.LogLevel
import io.realm.log.RealmLog

@HiltAndroidApp
class NewsApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        if (BuildConfig.DEBUG){
            RealmLog.setLevel(LogLevel.DEBUG)
        }else{
            RealmLog.setLevel(LogLevel.INFO)
        }
    }
}