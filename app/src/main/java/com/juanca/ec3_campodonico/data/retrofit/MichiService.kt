package com.juanca.ec3_campodonico.data.retrofit

import com.juanca.ec3_campodonico.data.response.MichiListResponse
import retrofit2.http.GET

interface MichiService {
    @GET("amiibo/")
    suspend fun getCupons(): MichiListResponse

    @GET("amiibo/?tail=00040002")
    suspend fun getFavorite(): MichiListResponse
}