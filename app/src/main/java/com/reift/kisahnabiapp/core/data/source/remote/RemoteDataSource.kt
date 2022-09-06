package com.reift.kisahnabiapp.core.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reift.kisahnabiapp.core.data.source.remote.network.ApiService
import com.reift.kisahnabiapp.core.data.source.remote.response.KisahResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RemoteDataSource private constructor(private val apiService: ApiService) {

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource {
            return instance ?: synchronized(this){
                instance ?: RemoteDataSource(service)
            }
        }
    }

    fun getKisahNabi(): LiveData<List<KisahResponse>>{
        val result = MutableLiveData<List<KisahResponse>>()

        apiService.getKisahNabi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                result.value = it
            }

        return result
    }
}