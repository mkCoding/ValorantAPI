package com.example.valorantapi.data.model.weapon


import com.google.gson.annotations.SerializedName

data class WeaponModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("status")
    val status: Int? = 0
)