package com.reift.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class KisahResponse(
	@field:SerializedName("usia")
	val usia: String,

	@field:SerializedName("icon_url")
	val iconUrl: String,

	@field:SerializedName("tmp")
	val tmp: String,

	@field:SerializedName("image_url")
	val imageUrl: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("thn_kelahiran")
	val thnKelahiran: String,

	@field:SerializedName("description")
	val description: String
)
