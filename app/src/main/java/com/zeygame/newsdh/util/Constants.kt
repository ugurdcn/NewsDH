package com.zeygame.newsdh.util

import androidx.lifecycle.MutableLiveData

object Constants {
    const val BASE_URL  = "https://api.donanimhaber.com/"
    const val END_POINT = "dev/and/api/newest?"

    val showProgress= MutableLiveData(false)
    var deleteListener : DeleteListener? = null
}