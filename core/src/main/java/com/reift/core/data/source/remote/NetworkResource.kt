package com.reift.core.data.source.remote

import com.reift.core.domain.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class NetworkResource<ResultType, RequestType> {

    init {
        fetchFromNetwork()
    }

    private var result = PublishSubject.create<Resource<ResultType>>()

    private val mCompositeDisposable = CompositeDisposable()

    protected abstract fun loadFromNetwork(data: RequestType): ResultType

    protected abstract fun createCall(): Flowable<RequestType>

    private fun fetchFromNetwork() {

        val apiResponse = createCall()

        result.onNext(Resource.Loading())
        val response = apiResponse
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .doOnComplete {
                mCompositeDisposable.dispose()
            }
            .subscribe {
                result.onNext(
                    Resource.Success(loadFromNetwork(it))
                )
            }
        mCompositeDisposable.add(response)
    }

    fun asFlowable(): Flowable<Resource<ResultType>> {
        return result.toFlowable(BackpressureStrategy.BUFFER)
    }
}