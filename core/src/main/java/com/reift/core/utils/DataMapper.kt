package com.reift.core.utils

import com.reift.core.data.source.remote.response.KisahResponse
import com.reift.core.domain.model.Kisah

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