package com.juanca.ec3_campodonico.view.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanca.ec3_campodonico.data.repository.MichisRepository
import com.juanca.ec3_campodonico.data.response.ApiResponse
import com.juanca.ec3_campodonico.data.retrofit.MichiService
import com.juanca.ec3_campodonico.model.Michi
import com.juanca.ec3_campodonico.model.getData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MichiListViewModel : ViewModel() {
    val repository = MichisRepository()
    val cuponList: MutableLiveData<List<Michi>> = MutableLiveData<List<Michi>>()

    fun getCuponList(){
        val data = getData()
        cuponList.value = data
    }

    fun getCuponsFromService(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCupons()
            when(response){
                is ApiResponse.Error ->{
                    //colocar error
                }
                is ApiResponse.Success ->{
                    cuponList.postValue(response.data.amiibo)
                }
            }
        }
    }
    fun getCuponsFromServiceFa() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCuponsFavorite()
            when (response) {
                is ApiResponse.Error -> {
                    // Manejar el error
                }
                is ApiResponse.Success -> {
                    cuponList.postValue(response.data.amiibo)

                }
            }
        }
    }


}