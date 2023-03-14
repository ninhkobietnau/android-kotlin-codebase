package com.ninhnau.base.aiart.domain.entity

data class Image(
    val gallery: String,
    val grid: Boolean,
    val guidance: Int,
    val height: Int,
    val id: String,
    val model: String,
    val nsfw: Boolean,
    val prompt: String,
    val promptid: String,
    val seed: String,
    val src: String,
    val srcSmall: String,
    val width: Int
)