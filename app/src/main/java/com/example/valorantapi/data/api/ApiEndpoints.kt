package com.example.valorantapi.data.api

import com.example.valorantapi.data.model.agent.AgentModel
import com.example.valorantapi.data.model.weapon.WeaponModel
import retrofit2.http.GET

interface ApiEndpoints {

    @GET(ApiDetails.AGENTS_ENDPOINT)
    suspend fun getAgents(): AgentModel

    @GET(ApiDetails.WEAPONS_ENDPOINT)
    suspend fun getWeapons(): WeaponModel
}