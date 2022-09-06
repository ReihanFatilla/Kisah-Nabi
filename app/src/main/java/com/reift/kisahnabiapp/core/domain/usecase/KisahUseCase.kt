package com.reift.kisahnabiapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.reift.kisahnabiapp.core.domain.model.Kisah
import io.reactivex.rxjava3.core.Flowable

interface KisahUseCase {
    fun getKisahNabi(): Flowable<List<Kisah>>
}