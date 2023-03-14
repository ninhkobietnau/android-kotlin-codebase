package com.ninhnau.base.aiart.data.remote.service

import com.ninhnau.base.aiart.domain.entity.AIArt
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AIArtService {
    @GET("search")
    suspend fun getArt(@Query("q") prompt: String): Response<AIArt>
}