package com.reift.kisahnabiapp.main

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.reift.kisahnabiapp.core.domain.usecase.KisahUseCase

class MainViewModel(kisahUseCase: KisahUseCase): ViewModel(){

    val listKisahNabi = LiveDataReactiveStreams.fromPublisher(kisahUseCase.getKisahNabi())
}