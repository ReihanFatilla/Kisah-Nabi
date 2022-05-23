package com.reift.kisahnabiapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reift.kisahnabiapp.data.KisahResponse
import com.reift.kisahnabiapp.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel: ViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    var isError = MutableLiveData<Throwable>()

    var kisahResponse = MutableLiveData<List<KisahResponse>>()

    fun getData(responseHandler: (List<KisahResponse>) -> Unit, errorHandler: (Throwable) -> Unit){
        ApiClient.getApiService().getKisahNabi()
            // Membuat Background Thread / Proses Asynchronous
            .subscribeOn(Schedulers.io())
            // menentukan dimana thread akan di buat
            .observeOn(AndroidSchedulers.mainThread())
            // mengatur hasil dari data, berhasil // gagal
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })

    }

    fun getKisahNabi(){
        isLoading.value = true
        getData({
            isLoading.value = false
            kisahResponse.value = it
        }, {
            isLoading.value = true
            isError.value = it
            })
    }
}