package com.reift.core.utils

import com.reift.core.domain.model.Kisah

interface OnItemClickCallback {
    fun onItemClicked(data: Kisah)
}