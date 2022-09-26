package com.reift.core.data

import com.reift.core.data.source.remote.RemoteDataSource
import com.reift.core.data.source.remote.response.KisahResponse
import com.reift.core.domain.Resource
import com.reift.core.domain.model.Kisah
import com.reift.core.domain.repository.IKisahRepository
import com.reift.core.utils.DataMapper
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.subjects.PublishSubject

class KisahRepository (
    private val remoteData: RemoteDataSource
): IKisahRepository {

    override fun getKisahNabi(): Flowable<Resource<List<Kisah>>> {
        return object : NetworkBoundResource<List<Kisah>, List<KisahResponse>>() {

            override fun createCall(): Flowable<List<KisahResponse>> {
                return remoteData.getKisahNabi()
            }

            override fun fetchFromNetwork(data: List<KisahResponse>): Flowable<List<Kisah>> {
                return remoteData.getKisahNabi().map {
                    DataMapper.mapResponseToDomain(it)
                }
            }
        }.asFlowable()
    }

}