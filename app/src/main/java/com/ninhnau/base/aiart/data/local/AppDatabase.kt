package com.ninhnau.base.aiart.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ninhnau.base.aiart.data.local.dao.ImageDao
import com.ninhnau.base.aiart.domain.entity.local.ImageLocal

@Database(
    entities = [ImageLocal::class],
    exportSchema = true,
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun imageDao(): ImageDao

    companion object{

        @Synchronized
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,
                "ai_art_db"
            ).fallbackToDestructiveMigration().build()
    }
}