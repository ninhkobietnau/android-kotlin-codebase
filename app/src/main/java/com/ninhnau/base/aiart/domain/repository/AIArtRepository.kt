package com.ninhnau.base.aiart.domain.repository

import androidx.lifecycle.LiveData
import com.ninhnau.base.aiart.domain.entity.AIArt
import com.ninhnau.base.aiart.domain.entity.local.ImageLocal
import com.ninhnau.base.common.utils.Resource

interface AIArtRepository {
    suspend fun getArt(prompt: String): LiveData<Resource<AIArt>>

    suspend fun addImage(imageLocal: ImageLocal): Long
    fun getAllImage(): LiveData<List<ImageLocal>>
    suspend fun deleteImage(id: Int)
}