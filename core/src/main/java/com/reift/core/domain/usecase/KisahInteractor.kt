package com.reift.core.domain.usecase

import com.reift.core.domain.Resource
import com.reift.core.domain.model.Kisah
import com.reift.core.domain.repository.IKisahRepository
import io.reactivex.rxjava3.core.Flowable

class KisahInteractor(val repository: IKisahRepository): KisahUseCase {
    override fun getKisahNabi(): Flowable<Resource<List<Kisah>>> {
        return repository.getKisahNabi()
    }
}