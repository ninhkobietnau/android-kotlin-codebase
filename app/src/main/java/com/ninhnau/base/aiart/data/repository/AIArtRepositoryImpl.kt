package com.ninhnau.base.aiart.data.repository

import androidx.lifecycle.LiveData
import com.ninhnau.base.aiart.data.local.dao.ImageDao
import com.ninhnau.base.aiart.data.remote.service.AIArtDataSource
import com.ninhnau.base.aiart.domain.entity.AIArt
import com.ninhnau.base.aiart.domain.entity.local.ImageLocal
import com.ninhnau.base.aiart.domain.repository.AIArtRepository
import com.ninhnau.base.common.utils.NetworkBoundResource
import com.ninhnau.base.common.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class AIArtRepositoryImpl @Inject constructor(
    private val dao: ImageDao,
    private val dataSource: AIArtDataSource
): AIArtRepository {
    override suspend fun getArt(prompt: String): LiveData<Resource<AIArt>> {
        return object : NetworkBoundResource<AIArt, AIArt>() {
            override fun processResponse(response: Response<AIArt>): AIArt {
                return response.body() ?: AIArt(emptyList())
            }

            override suspend fun createCallAsync(): Response<AIArt> {
                return dataSource.getArt(prompt)
            }

        }.build().asLiveData()
    }

    override suspend fun addImage(imageLocal: ImageLocal): Long {
        return dao.insertImage(imageLocal)
    }

    override fun getAllImage(): LiveData<List<ImageLocal>> {
        return dao.getAllImage()
    }

    override suspend fun deleteImage(id: Int) {
        dao.deleteImage(id)
    }
}