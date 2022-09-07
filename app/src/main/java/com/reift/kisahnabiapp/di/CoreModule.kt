package com.reift.kisahnabiapp.di

import com.reift.core.domain.usecase.KisahInteractor
import com.reift.core.domain.usecase.KisahUseCase
import com.reift.kisahnabiapp.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<KisahUseCase>{ KisahInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}