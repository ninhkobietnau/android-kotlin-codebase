package com.ninhnau.base.aiart.data.remote.service

import javax.inject.Inject

class AIArtDataSource @Inject constructor(private val service: AIArtService) {
    suspend fun getArt(prompt: String) = service.getArt(prompt)
}