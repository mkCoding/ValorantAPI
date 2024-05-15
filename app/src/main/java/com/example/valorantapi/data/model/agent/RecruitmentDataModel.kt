package com.example.valorantapi.data.model.agent


import com.google.gson.annotations.SerializedName

data class RecruitmentDataModel(
    @SerializedName("counterId")
    val counterId: String? = "",
    @SerializedName("endDate")
    val endDate: String? = "",
    @SerializedName("levelVpCostOverride")
    val levelVpCostOverride: Int? = 0,
    @SerializedName("milestoneId")
    val milestoneId: String? = "",
    @SerializedName("milestoneThreshold")
    val milestoneThreshold: Int? = 0,
    @SerializedName("startDate")
    val startDate: String? = "",
    @SerializedName("useLevelVpCostOverride")
    val useLevelVpCostOverride: Boolean? = false
)