package com.reift.kisahnabiapp.core.utils

import com.reift.kisahnabiapp.core.data.network.response.KisahResponse
import com.reift.kisahnabiapp.core.domain.model.Kisah

interface OnItemClickCallback {
    fun onItemClicked(data: Kisah)
}