package com.reift.core.data

import com.reift.core.domain.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result = PublishSubject.create<Resource<ResultType>>()

    private val mCompositeDisposable = CompositeDisposable()

    init {
        subscribe()
    }

    private fun subscribe() {
        val apiResponse = createCall()

        result.onNext(Resource.Loading())
        val response = apiResponse
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .doOnComplete {
                mCompositeDisposable.dispose()
            }
            .subscribe { request ->
                val networkSource = fetchFromNetwork(request)
                networkSource.subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .take(1)
                    .subscribe {
                        networkSource.unsubscribeOn(Schedulers.io())
                        result.onNext(Resource.Success(it))
                    }
            }
        mCompositeDisposable.add(response)
    }


    protected abstract fun fetchFromNetwork(data: RequestType): Flowable<ResultType>

    protected abstract fun createCall(): Flowable<RequestType>

    fun asFlowable(): Flowable<Resource<ResultType>> {
        return result.toFlowable(BackpressureStrategy.BUFFER)
    }
}