package com.ninhnau.base.aiart.domain.usecase

import com.ninhnau.base.aiart.domain.entity.local.ImageLocal
import com.ninhnau.base.aiart.domain.repository.AIArtRepository
import javax.inject.Inject

class AddImageUseCase @Inject constructor(
    private val repository: AIArtRepository
) {
    suspend operator fun invoke(imageLocal: ImageLocal) = repository.addImage(imageLocal)
}