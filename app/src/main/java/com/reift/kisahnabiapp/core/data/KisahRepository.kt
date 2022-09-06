package com.reift.kisahnabiapp.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.reift.kisahnabiapp.core.data.source.remote.RemoteDataSource
import com.reift.kisahnabiapp.core.domain.model.Kisah
import com.reift.kisahnabiapp.core.domain.repository.IKisahRepository
import com.reift.kisahnabiapp.core.utils.DataMapper

class KisahRepository private constructor(
    private val remoteData: RemoteDataSource
): IKisahRepository {

    companion object{
        @Volatile
        private var instance: KisahRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource
        ): KisahRepository{
            return instance ?: synchronized(this){
                instance ?: KisahRepository(remoteData)
            }
        }
    }

    override fun getKisahNabi(): LiveData<List<Kisah>> {
        return Transformations.map(remoteData.getKisahNabi()){
            DataMapper.mapResponseToDomain(it)
        }
    }

}