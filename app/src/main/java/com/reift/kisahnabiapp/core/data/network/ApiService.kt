package com.reift.kisahnabiapp.core.data.network

import com.reift.kisahnabiapp.core.data.network.response.KisahResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("kisahnabi")
    fun getKisahNabi(): Flowable<List<KisahResponse>>
}