package com.example.valorantapi.data.model.agent


import com.google.gson.annotations.SerializedName

data class RoleModel(
    @SerializedName("assetPath")
    val assetPath: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("displayIcon")
    val displayIcon: String? = "",
    @SerializedName("displayName")
    val displayName: String? = "",
    @SerializedName("uuid")
    val uuid: String? = ""
)