package com.ninhnau.base.aiart.domain.entity.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class ImageLocal(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,

    @ColumnInfo(name = "path", defaultValue = "")
    val path: String,

    @ColumnInfo(name = "prompt", defaultValue = "")
    val prompt: String
) : Parcelable
