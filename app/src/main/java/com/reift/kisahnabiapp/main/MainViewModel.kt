package com.reift.kisahnabiapp.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reift.kisahnabiapp.core.data.network.response.KisahResponse
import com.reift.kisahnabiapp.core.data.network.ApiClient
import com.reift.kisahnabiapp.core.domain.usecase.KisahUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(kisahUseCase: KisahUseCase): ViewModel() {

    val listKisahNabi = kisahUseCase.getKisahNabi()
}