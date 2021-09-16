package com.zeygame.newsdh.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RealmModule {
    @Provides
    @Singleton
    fun provideRealmDatabase(@ApplicationContext context: Context): Realm {
        Realm.init(context)
        val realmConfig = RealmConfiguration.Builder()
            .name("News")
            .build()
        Realm.setDefaultConfiguration(realmConfig)
        return Realm.getDefaultInstance()
    }
}