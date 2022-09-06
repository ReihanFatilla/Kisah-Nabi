package com.reift.kisahnabiapp.core.utils

import com.reift.kisahnabiapp.core.domain.model.Kisah

interface OnItemClickCallback {
    fun onItemClicked(data: Kisah)
}