package com.reift.core.data

import com.reift.core.data.source.remote.RemoteDataSource
import com.reift.core.domain.model.Kisah
import com.reift.core.domain.repository.IKisahRepository
import com.reift.core.utils.DataMapper
import io.reactivex.rxjava3.core.Flowable

class KisahRepository (
    private val remoteData: RemoteDataSource
): IKisahRepository {

    override fun getKisahNabi(): Flowable<List<Kisah>> {

        return remoteData.getKisahNabi().map {
            DataMapper.mapResponseToDomain(it)
        }
    }

}