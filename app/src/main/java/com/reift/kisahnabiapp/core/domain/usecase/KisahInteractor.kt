package com.reift.kisahnabiapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.reift.kisahnabiapp.core.domain.model.Kisah
import com.reift.kisahnabiapp.core.domain.repository.IKisahRepository
import io.reactivex.rxjava3.core.Flowable

class KisahInteractor(val repository: IKisahRepository): KisahUseCase {
    override fun getKisahNabi(): Flowable<List<Kisah>> {
        return repository.getKisahNabi()
    }
}