package com.zeygame.newsdh.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeygame.newsdh.model.Data
import com.zeygame.newsdh.model.News
import com.zeygame.newsdh.model.ResultModel
import com.zeygame.newsdh.repository.NewsRepository
import com.zeygame.newsdh.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository : NewsRepository) : ViewModel() {
    private val _response = MutableLiveData<ResultModel>()
    val newsResponse : LiveData<ResultModel>
    get() =_response


    init {
        getNews(0,15)

    }

    fun getNews(pageIndex:Int,pageSize:Int) = viewModelScope.launch  {
        try {
            repository.getNews(pageIndex,pageSize).let {
                Constants.showProgress.postValue(false)
                it?.let {
                    if (it?.isSuccessful) {
                        it.body()?.let {
                            _response.postValue(it)
                        }
                    } else {
                        Log.d("MYTAG", "HATA OLUŞTU ${it.code()}")
                    }
                }
            }
        }catch (e:ConnectException) {
            e.printStackTrace()
        }
    }

}