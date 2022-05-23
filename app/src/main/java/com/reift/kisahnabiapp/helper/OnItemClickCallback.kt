package com.reift.kisahnabiapp.helper

import com.reift.kisahnabiapp.data.KisahResponse

interface OnItemClickCallback {
    fun onItemClicked(data: KisahResponse)
}