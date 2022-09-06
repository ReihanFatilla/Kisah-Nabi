package com.reift.kisahnabiapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.reift.kisahnabiapp.core.domain.model.Kisah

interface KisahUseCase {
    fun getKisahNabi(): LiveData<List<Kisah>>
}