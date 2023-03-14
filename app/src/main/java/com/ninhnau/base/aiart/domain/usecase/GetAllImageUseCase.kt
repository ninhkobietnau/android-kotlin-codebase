package com.ninhnau.base.aiart.domain.usecase

import com.ninhnau.base.aiart.domain.repository.AIArtRepository
import javax.inject.Inject

class GetAllImageUseCase @Inject constructor(
    private val repository: AIArtRepository
) {
    operator fun invoke() = repository.getAllImage()
}