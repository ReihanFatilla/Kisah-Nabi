package com.reift.core.domain.usecase

import com.reift.core.domain.model.Kisah
import io.reactivex.rxjava3.core.Flowable

interface KisahUseCase {
    fun getKisahNabi(): Flowable<List<Kisah>>
}