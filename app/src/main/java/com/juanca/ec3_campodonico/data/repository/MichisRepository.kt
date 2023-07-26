package com.juanca.ec3_campodonico.data.repository

import com.juanca.ec3_campodonico.data.response.ApiResponse
import com.juanca.ec3_campodonico.data.response.MichiListResponse
import com.juanca.ec3_campodonico.data.retrofit.ServiceInstance

class MichisRepository {
    suspend fun getCupons(): ApiResponse<MichiListResponse> {
        return try {
            val response = ServiceInstance.getMichiService().getCupons()
            ApiResponse.Success(response)
        }catch (e: Exception){
            ApiResponse.Error(e)
        }


    }
    suspend fun getCuponsFavorite(): ApiResponse<MichiListResponse> {
        return try {
            val response = ServiceInstance.getMichiService().getFavorite()
            ApiResponse.Success(response)
        }catch (e: Exception){
            ApiResponse.Error(e)
        }


    }
}