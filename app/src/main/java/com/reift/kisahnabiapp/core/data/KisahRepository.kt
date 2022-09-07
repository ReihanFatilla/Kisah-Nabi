package com.reift.kisahnabiapp.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.reift.kisahnabiapp.core.data.source.remote.RemoteDataSource
import com.reift.kisahnabiapp.core.domain.model.Kisah
import com.reift.kisahnabiapp.core.domain.repository.IKisahRepository
import com.reift.kisahnabiapp.core.utils.DataMapper
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