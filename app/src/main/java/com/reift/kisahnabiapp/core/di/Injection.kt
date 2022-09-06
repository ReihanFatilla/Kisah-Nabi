package com.reift.kisahnabiapp.core.di

import com.reift.kisahnabiapp.core.data.KisahRepository
import com.reift.kisahnabiapp.core.data.source.remote.network.ApiClient
import com.reift.kisahnabiapp.core.data.source.remote.RemoteDataSource
import com.reift.kisahnabiapp.core.domain.repository.IKisahRepository
import com.reift.kisahnabiapp.core.domain.usecase.KisahInteractor
import com.reift.kisahnabiapp.core.domain.usecase.KisahUseCase

object Injection {
    fun provideRepository(): IKisahRepository{
        val remoteData = RemoteDataSource.getInstance(ApiClient.getApiService())

        return KisahRepository.getInstance(remoteData)
    }

    fun provideUseCase(): KisahUseCase{
        val repository = provideRepository()
        return KisahInteractor(repository)
    }
}