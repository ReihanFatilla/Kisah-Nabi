package com.reift.kisahnabiapp.core.di

import com.reift.kisahnabiapp.BuildConfig
import com.reift.kisahnabiapp.core.data.KisahRepository
import com.reift.kisahnabiapp.core.data.source.remote.RemoteDataSource
import com.reift.kisahnabiapp.core.data.source.remote.network.ApiService
import com.reift.kisahnabiapp.core.domain.repository.IKisahRepository
import com.reift.kisahnabiapp.core.domain.usecase.KisahInteractor
import com.reift.kisahnabiapp.core.domain.usecase.KisahUseCase
import com.reift.kisahnabiapp.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

val networkModule = module{
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<IKisahRepository> { KisahRepository(get()) }
}

val useCaseModule = module {
    factory<KisahUseCase>{ KisahInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}