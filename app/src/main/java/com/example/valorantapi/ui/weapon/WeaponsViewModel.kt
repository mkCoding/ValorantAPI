package com.example.valorantapi.ui.weapon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapi.data.api.ApiResponse
import com.example.valorantapi.data.model.weapon.WeaponModel
import com.example.valorantapi.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val apiRepository: ApiRepository
): ViewModel() {

    private val _weaponList = MutableLiveData<ApiResponse<WeaponModel>>()

    val weaponList: LiveData<ApiResponse<WeaponModel>> = _weaponList

    init {
        getWeapons()
    }

    private fun getWeapons() {
        viewModelScope.launch {
            val result = apiRepository.getWeapons()

            _weaponList.postValue(ApiResponse.SuccessState(result))



        }
    }
}