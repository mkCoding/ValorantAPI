package com.example.valorantapi.data.repository

import com.example.valorantapi.data.api.ApiEndpoints
import com.example.valorantapi.data.model.agent.AgentModel
import com.example.valorantapi.data.model.agent.DataModel
import com.example.valorantapi.data.model.weapon.WeaponModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiDetails: ApiEndpoints): ApiRepository{
    override suspend fun getAgents(): AgentModel = apiDetails.getAgents()

    override suspend fun getWeapons(): WeaponModel = apiDetails.getWeapons()

}