package com.reift.kisahnabiapp.core.utils

import com.reift.kisahnabiapp.core.data.network.response.KisahResponse
import com.reift.kisahnabiapp.core.domain.model.Kisah

object DataMapper {
    fun mapResponseToDomain(input: List<KisahResponse>): List<Kisah>{

        val domain = ArrayList<Kisah>()
        input.map {
            val kisah = Kisah(
                it.name,
                it.iconUrl,
                it.tmp,
                it.imageUrl,
                it.name,
                it.thnKelahiran,
                it.description
            )
            domain.add(kisah)
        }

        return domain
    }
}