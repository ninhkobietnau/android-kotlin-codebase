package com.ninhnau.base.aiart.domain.usecase

import com.ninhnau.base.aiart.domain.repository.AIArtRepository
import javax.inject.Inject

class DeleteImageUseCase @Inject constructor(
    private val repository: AIArtRepository
) {
    suspend operator fun invoke(id: Int) = repository.deleteImage(id)
}