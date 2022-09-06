package com.reift.kisahnabiapp.core.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reift.kisahnabiapp.core.data.source.remote.network.ApiService
import com.reift.kisahnabiapp.core.data.source.remote.response.KisahResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

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

    fun getKisahNabi(): Flowable<List<KisahResponse>>{
        // Menggunakan RXJava
        val result = PublishSubject.create<List<KisahResponse>>()

        // Menggunakan LiveData
//        val result = MutableLiveData<List<KisahResponse>>()

        apiService.getKisahNabi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                // Menggunakan RXJava
                val dataArray = it
                result.onNext(
                    dataArray
                )
                // Menggunakan LiveData
//                result.value = it
            }

        // Menggunakan RXJava
        return result.toFlowable(BackpressureStrategy.BUFFER)

        // Menggunakan LiveData
//        return result


    }
}