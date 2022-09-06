package com.reift.kisahnabiapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.reift.kisahnabiapp.core.domain.model.Kisah

interface IKisahRepository {
    fun getKisahNabi(): LiveData<List<Kisah>>
}