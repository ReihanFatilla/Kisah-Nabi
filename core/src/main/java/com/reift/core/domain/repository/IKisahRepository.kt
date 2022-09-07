package com.reift.core.domain.repository

import com.reift.core.domain.model.Kisah
import io.reactivex.rxjava3.core.Flowable

interface IKisahRepository {
    fun getKisahNabi(): Flowable<List<Kisah>>
}