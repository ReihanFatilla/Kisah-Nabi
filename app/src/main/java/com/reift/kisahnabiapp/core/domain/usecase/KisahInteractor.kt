package com.reift.kisahnabiapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.reift.kisahnabiapp.core.domain.model.Kisah
import com.reift.kisahnabiapp.core.domain.repository.IKisahRepository

class KisahInteractor(val repository: IKisahRepository): KisahUseCase {
    override fun getKisahNabi(): LiveData<List<Kisah>> {
        return repository.getKisahNabi()
    }
}