package com.reift.core.data.source.remote

import com.reift.core.data.source.remote.network.ApiService
import com.reift.core.data.source.remote.response.KisahResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

class RemoteDataSource(private val apiService: ApiService) {

    fun getKisahNabi(): Flowable<List<KisahResponse>>{
        return apiService.getKisahNabi()
    }

    private fun <T> getFlowableList(kisahNabi: Flowable<T>): Flowable<T> {

        val result = PublishSubject.create<T>()

        kisahNabi.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                val dataArray = it
                result.onNext(
                    dataArray
                )
            }

        return result.toFlowable(BackpressureStrategy.BUFFER)
    }
}