package com.ninhnau.base.aiart.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ninhnau.base.aiart.domain.entity.local.ImageLocal

@Dao
abstract class ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertImage(habit: ImageLocal): Long

    @Query("SELECT * FROM imagelocal")
    abstract fun getAllImage(): LiveData<List<ImageLocal>>

    @Query("DELETE FROM imagelocal WHERE id=:id")
    abstract suspend fun deleteImage(id: Int)
}