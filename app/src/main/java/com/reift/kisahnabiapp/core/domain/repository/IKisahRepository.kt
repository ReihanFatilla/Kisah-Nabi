package com.reift.kisahnabiapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.reift.kisahnabiapp.core.domain.model.Kisah
import io.reactivex.rxjava3.core.Flowable

interface IKisahRepository {
    fun getKisahNabi(): Flowable<List<Kisah>>
}