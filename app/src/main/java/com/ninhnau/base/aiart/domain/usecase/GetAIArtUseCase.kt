package com.ninhnau.base.aiart.domain.usecase

import com.ninhnau.base.aiart.domain.repository.AIArtRepository
import javax.inject.Inject

class GetAIArtUseCase @Inject constructor(
    private val repository: AIArtRepository
) {
    suspend operator fun invoke(prompt: String) = repository.getArt(prompt)
}